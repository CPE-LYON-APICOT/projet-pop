
# Retro-conception

**Binome 1 : [PERRAT Tom]**
**Binome 2 : [BELALOUI Jamy]**

Complétez ce document pour décrire votre projet, les difficultés rencontrées, les design patterns mis en oeuvre, les améliorations possibles, et en quoi la POO vous a été utile.

> **Faites le avec sérieux, ce document ainsi que votre code seront évalués.**
Si vous considérez que votre code est quasi-parfait, je vais chercher les erreurs et en trouver, et cela vous pénalisera.
Si vous êtes critique envers vous-même et que vous expliquez correctement vos difficultés, vous serez "à moitié" pardonné.

Ce n'est pas grave de ne pas avoir été au bout de ce que vous vouliez faire, comportez vous comme un ingénieur qui doit rendre des comptes à son client, et qui doit expliquer pourquoi il n'a pas pu tout faire.
Pour rappel le client n'est pas un developpeur (sinon il ne vous aurait pas payé une fortune pour le faire à sa place), vous devez lui expliquer de manière simple et claire les problèmes rencontrés, en vous justifiant 
>Imaginez que vous avez codé Mortal Kombat 
Ne dites pas "je n'ai pas eu le temps de tout faire", mais plutôt "j'ai préféré me concentrer sur la création des spectaculaires "Finish Him" des personnages car c'est un élément essentiel du gameplay, cependant la difficulté dynamique en fonction de la maîtrise du joueur n'a pas pu être implémentée à temps, compte tenu que les critères de maîtrises sont difficilement modélisables, toutefois nous pourrions envisager d'implémenter que plus le combat dure longtemps, plus les coups portés sont puissants, ce qui est rapide à implémenter et lors d'une mise à jour, nous pourrions remplacer ce système par quelque chose de plus élaboré"

Aussi, en entreprise, vous serez confronté à des programmes très mal codés, et vous allez galérer à les comprendre, vous risquez d'essayer de les corriger et tomber dans les mêmes ecueils que les développeurs précédents.
Pour cela, il est courrant de tenir un jour un Document d'Architecture Technique (DAT) qui explique comment fonctionne le programme, et comment le reprendre ainsi qu'un document de réversibilité qui explique comment reprendre le code de quelqu'un d'autre.
(C'est obligatoire pour les marchés publics de prévoir une réversibilité, c'est à dire que le client peut vous dégager et une autre entreprise doit pouvoir reprendre votre code sans difficulté)
Dans ces documents, il ne s'agit pas de cacher la poussière sous le tapis, il faut être honnête et proposer une vision d'ensemble de votre code, et expliquer pourquoi vous avez fait des choix, et pourquoi vous n'avez pas fait d'autres choix, il est souvent question de compromis (on fait un truc pas ouf pour gagner du temps, mais la qualité du code en pâtit, etc.)
> Vous pouvez dire : "Pour la gestion des collisions, nous utilisons une librairie tierce, toutefois celle-ci ne gère que les collisions entre des rectangles, au fur et à mesure des itérations, des ennemis de grande taille et de forme complexe sont apparus, toutefois, nous avons conservé une hitbox rectangulaire, en résulte que le joueur peut être touché alors que visuellement, il n'est pas en contact avec l'ennemi ; nous avions également envisagé de créer plusieurs hitbox de tailles différentes sur un même ennemi afin de mieux coller à la forme de celui-ci, toutefois, les performances du jeu ont étés trop dégradées"



---
# Partie "Client" (pas trop technique) :

## Objectif du projet

L'objectif initial de notre projet était de réaliser une nouvelle version du jeu Snake, proposant en plus des pommes(ou autre fruit), des bonbons faisant varier la vitesse du serpent et des objets à effets (Destruction de mur, vie supplémentaires, etc.). Nous avions aussi pour but de proposer des modes de jeux différents avec chacun une particularité. Par exemple, un mode donjon avec des ennemis et différents étages de plus en plus difficiles à atteindre, un mode avec plusieurs serpents contrôlés simultanément, ou encore avec de nouveaux obstacles.

## Résultat

Notre objectif a été partiellement atteint, nous avons un code fonctionnel qui permet de jouer une partie avec des fruits octroyant différentes quantités de points au joueur dépendamment de la couleur de l'objet collecté et de la vitesse du serpent, le score est affiché.

 La partie est perdue si une des conditions suivantes est remplie :
 
- Le serpent touche un mur
- Le serpent touche sa queue

La partie est considérée comme gagnée si toutes les cases de la grilles sont occupées par le serpent

Mécanismes de la partie : Au début de la partie, le serpent apparait dans la grille de jeu, ainsi qu'un fruit et un bonbon, lorsque le joueur collecte un fruit, un autre fruit d'une couleur aléatoire apparait (même chose pour les bonbons), la couleur fera varier le nombre de points octroyé par les bonbons et les fruits et la vitesse du serpent dépend du dernier bonbon mangé. Plus la vitesse du serpent est élevée, plus le multiplicateur de score est élevé.

### Améliorations possibles

La partie gameplay permettant de jouer une partie entièrement, nous aurions souhaité amélioré la partie visuelle du jeu puis ajouter des murs ou autres éléments sur la grille afin de stimuler davantage le joueur. L'ajout d'objets à effets spéciaux serait le point suivant sur lequel nous aurions travaillé dans le but de diversifier le gameplay.
Puis dans un futur un peu plus lointain, nous aurions souhaité développer d'autres modes de jeu 

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

[Si pendant votre implémentation, vous trouvez que vous pouvez être particulièrment fiers d'une partie de votre code, décrivez là ici ; par exemple si vous avez généré une carte de manière procédurale, ou à l'aide d'un fichier]

### Faiblesses du code

Les bonbons et les fruits ont le même type, ils partagent donc les mêmes attributs (points et speed), ce qui entrainait des comportements non souhaités (voir Difficulté rencontrée n°1)
Impossibilité d'ajouter un nouvel objet sans ajouter sa couleur 

### Difficultés rencontrées

#### 1. [Gestion des attributs des bonbons et des fruits]

Après que le serpent ait collecté un bonbon, sa vitesse changeait en fonction du bonbon collecté (comme prévu), mais la collecte d'un fruit réinitialisait cette vitesse car les objets de type iItem auquel appartiennent les fruits et les bonbons ont un attribut vitesse qui est initialisé à 1.
Le vitesse du serpent était donc égale à la vitesse du jeu de base / 1.

#### 2. [L'implémentation des design patterns]

Nous avons mis du temps à comprendre le fonctionnement des design pattern, mais l'implémentation de ces derniers dans le contexte du jeu Snake n'a pas été simple, mais après beaucoup de communication et d'entraide, nous avons surmonté cette difficulté


### *Design Patterns* mis en oeuvre

#### 1. [Décorateurs]
Nous avons utilisés des décorateurs afin d'appliquer différentes quantités de points aux fruits et différentes vitesses aux différents bonbons dépendamment de leur couleur

[Ajouter éventuellement des exemples de code pour montrer l'élégence de votre solution, pour cela vous pouvez écrire en Markdown votre code ainsi :

<pre>
```java
public class Factory {
    public static Object createObject(String type) {
        if (type.equals("type1")) {
            return new Type1();
        } else if (type.equals("type2")) {
            return new Type2();
        }
        return null;
    }
}
```
</pre>

]

---
# Partie pédagogique


### En quoi la POO vous a été utile

[Par exemple, expliquez que vous auriez éprouvé des difficultés à gérer les collisions si vous n'aviez pas utilisé la POO, ou que vous avez pu facilement ajouter des fonctionnalités à votre jeu grâce à la POO
Minimum 10 lignes (personnalisé en fonction de votre projet)]

### Conclusion

[Décrivez ici si vous avez compris un concept particulier que vous n'aviez pas compris en cours, inversement si vous pensiez qu'il était possible de faire qqchose mais que cela ne s'est pas passé comme prévu]