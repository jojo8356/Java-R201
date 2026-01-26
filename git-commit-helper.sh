#!/bin/bash

# Script de génération automatique de messages de commit professionnels
# Analyse les fichiers .java modifiés et génère un descriptif intelligent

echo "=========================================="
echo "   Analyseur de commits Java - R201"
echo "=========================================="
echo ""

# Couleurs
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Vérifier si on est dans un repo git
if [ ! -d ".git" ]; then
    echo -e "${RED}Erreur: Ce n'est pas un dépôt Git${NC}"
    exit 1
fi

# Fichiers modifiés
STAGED=$(git diff --cached --name-only --diff-filter=M 2>/dev/null | grep "\.java$")
ADDED=$(git diff --cached --name-only --diff-filter=A 2>/dev/null | grep "\.java$")
DELETED=$(git diff --cached --name-only --diff-filter=D 2>/dev/null | grep "\.java$")

# Fichiers non stagés
UNSTAGED=$(git diff --name-only 2>/dev/null | grep "\.java$")
UNTRACKED=$(git ls-files --others --exclude-standard 2>/dev/null | grep "\.java$")

echo -e "${BLUE}=== État des fichiers Java ===${NC}"
echo ""

# Afficher les fichiers ajoutés
if [ -n "$ADDED" ]; then
    echo -e "${GREEN}[+] Nouveaux fichiers:${NC}"
    for file in $ADDED; do
        classname=$(basename "$file" .java)
        echo "    - $classname"
    done
    echo ""
fi

# Afficher les fichiers modifiés
if [ -n "$STAGED" ]; then
    echo -e "${YELLOW}[~] Fichiers modifiés:${NC}"
    for file in $STAGED; do
        classname=$(basename "$file" .java)
        echo "    - $classname"
    done
    echo ""
fi

# Afficher les fichiers supprimés
if [ -n "$DELETED" ]; then
    echo -e "${RED}[-] Fichiers supprimés:${NC}"
    for file in $DELETED; do
        classname=$(basename "$file" .java)
        echo "    - $classname"
    done
    echo ""
fi

# Fichiers non suivis
if [ -n "$UNTRACKED" ]; then
    echo -e "${YELLOW}[?] Fichiers non suivis (git add requis):${NC}"
    for file in $UNTRACKED; do
        classname=$(basename "$file" .java)
        echo "    - $classname"
    done
    echo ""
fi

echo -e "${BLUE}=== Suggestion de message de commit ===${NC}"
echo ""

# Générer le message de commit
generate_commit_message() {
    local prefix=""
    local description=""
    local details=""

    # Compter les fichiers
    added_count=$(echo "$ADDED" | grep -c "\.java$" 2>/dev/null || echo 0)
    staged_count=$(echo "$STAGED" | grep -c "\.java$" 2>/dev/null || echo 0)
    deleted_count=$(echo "$DELETED" | grep -c "\.java$" 2>/dev/null || echo 0)

    # Déterminer le type de commit
    if [ "$added_count" -gt 0 ] && [ "$staged_count" -eq 0 ] && [ "$deleted_count" -eq 0 ]; then
        prefix="feat"
        if [ "$added_count" -eq 1 ]; then
            classname=$(basename $(echo "$ADDED" | head -1) .java)
            description="ajout de la classe $classname"
        else
            description="ajout de $added_count nouvelles classes"
        fi
    elif [ "$staged_count" -gt 0 ] && [ "$added_count" -eq 0 ]; then
        prefix="refactor"
        if [ "$staged_count" -eq 1 ]; then
            classname=$(basename $(echo "$STAGED" | head -1) .java)
            description="modification de la classe $classname"
        else
            description="modification de $staged_count classes"
        fi
    elif [ "$deleted_count" -gt 0 ] && [ "$added_count" -eq 0 ] && [ "$staged_count" -eq 0 ]; then
        prefix="chore"
        description="suppression de classes obsolètes"
    else
        prefix="feat"
        description="mise à jour du projet"
    fi

    # Analyser le contenu des fichiers ajoutés pour plus de détails
    if [ -n "$ADDED" ]; then
        for file in $ADDED; do
            if [ -f "$file" ]; then
                # Détecter si c'est une interface, classe abstraite, enum, etc.
                if grep -q "public interface" "$file" 2>/dev/null; then
                    details="$details\n- Interface: $(basename $file .java)"
                elif grep -q "public abstract class" "$file" 2>/dev/null; then
                    details="$details\n- Classe abstraite: $(basename $file .java)"
                elif grep -q "public enum" "$file" 2>/dev/null; then
                    details="$details\n- Enumération: $(basename $file .java)"
                elif grep -q "public class" "$file" 2>/dev/null; then
                    # Détecter l'héritage
                    if grep -q "extends" "$file" 2>/dev/null; then
                        parent=$(grep -oP "extends\s+\K\w+" "$file" | head -1)
                        details="$details\n- Classe $(basename $file .java) (hérite de $parent)"
                    elif grep -q "implements" "$file" 2>/dev/null; then
                        iface=$(grep -oP "implements\s+\K[\w,\s]+" "$file" | head -1 | cut -d' ' -f1)
                        details="$details\n- Classe $(basename $file .java) (implémente $iface)"
                    else
                        details="$details\n- Classe: $(basename $file .java)"
                    fi
                fi
            fi
        done
    fi

    # Afficher le message suggéré
    echo -e "${GREEN}$prefix: $description${NC}"

    if [ -n "$details" ]; then
        echo ""
        echo "Détails:"
        echo -e "$details"
    fi

    echo ""
    echo "----------------------------------------"
    echo "Commande suggérée:"
    echo -e "${YELLOW}git commit -m \"$prefix: $description\"${NC}"
}

# Vérifier s'il y a des changements
if [ -z "$ADDED" ] && [ -z "$STAGED" ] && [ -z "$DELETED" ]; then
    if [ -n "$UNTRACKED" ] || [ -n "$UNSTAGED" ]; then
        echo -e "${YELLOW}Aucun fichier Java stagé.${NC}"
        echo "Utilisez 'git add' pour ajouter vos fichiers."
        echo ""
        echo "Suggestion: git add *.java"
    else
        echo -e "${YELLOW}Aucune modification Java détectée.${NC}"
    fi
else
    generate_commit_message
fi

echo ""
