
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

La partie gameplay permettant de jouer une partie entièrement, nous aurions souhaité amélioré la partie visuelle du jeu puis ajouter des murs ou autres éléments sur la grille afin d'améliorer l'expérience de jeu. L'ajout d'objets à effets spéciaux serait le point suivant sur lequel nous aurions travaillé dans le but de diversifier le gameplay.
Puis dans un futur un peu plus lointain, nous aurions souhaité développer d'autres modes de jeu 

---
# Partie "Développeur" (plus technique) :


### Implémentations remarquables

[Si pendant votre implémentation, vous trouvez que vous pouvez être particulièrment fiers d'une partie de votre code, décrivez là ici ; par exemple si vous avez généré une carte de manière procédurale, ou à l'aide d'un fichier]

### Faiblesses du code

La taille de la grille est définie dans le service de gestion des objets(voir difficulté rencontrée 3).

L'affichage est simple mais peu modulable, si on rajoute un item, son numéro plus grand décalera l'affichage, et il faut rajouter une couleur à l'objet sous peine que le programme crash car sinon il essaie d'accéder à un index en dehors du tableau pour trouver la couleur.

### Difficultés rencontrées

#### 1. [Gestion des attributs des bonbons et des fruits]

Après que le serpent ait collecté un bonbon, sa vitesse changeait en fonction du bonbon collecté (comme prévu), mais la collecte d'un fruit réinitialisait cette vitesse car les objets de type iItem auquel appartiennent les fruits et les bonbons ont un attribut vitesse qui est initialisé à 0. Le décorateur ajoutait donc 0 à la vitesse de base du serpent (1)
Le vitesse du serpent était donc égale à la vitesse du jeu de base / la vitesse du serpent de base.
Nous avons fais en sorte de vérifier la vitesse de l'Item puis on ne l'applique à la vitesse du serpent que si sa valeur est différente de 0.

#### 2. [L'implémentation des design patterns]

Nous avons mis du temps à comprendre le fonctionnement des design pattern, l'implémentation de ces derniers dans le contexte de notre jeu n'a pas été simple, la plupart n'ayant pas de réelle utilité pour Snake mais avec du temps et des recherches ainsi que de l'aide de notre professeur, nous avons finalement réussi à en mettre en place certains dans notre code.

#### 3. [Impossibilité d'accéder à la classe Grid depuis la classe ObjetService]

La taille de la grille de jeu se trouve dans ObjetService car on peut accéder à cette classe depuis la classe Grid (qui contient la grille de jeu) mais on ne peut pas accéder à ObjetService depuis Grid car nous ne maîtrisons pas suffisamment l'injection de dépendances. Nous n'avons pas réussi à résoudre le problème.

### *Design Patterns* mis en oeuvre

#### 1. [Décorateurs]
Nous avons utilisés des décorateurs afin d'appliquer différentes quantités de points aux fruits et différentes vitesses aux différents bonbons dépendamment de leur couleur

Nos décorateurs utilisent une interface iItem qui est implémentée par la classe abstraite Item, elle contient les fonctions qui permettent de récupérer les coordonnées d'un objet, les points et la vitesse qu'il octroie. Pour les fruits et les bonbons, on crée respectivement un objet basique (basicCandy et basicFruit) sur lesquels nous appliquons nos décorateurs. Actuellement, nous avons trois décorateurs pour les fruits et trois pour les couleurs (chaque couleur correspond à un nombre de points différent pour les fruits et à une vitesse différente pour les bonbons)



```java



public interface iItem {
    Integer getY();

    void setY(Integer y);

    Integer getX();

    void setX(Integer x);

    Integer getPoints();

    Double getSpeed();

    Entry<Integer, Integer> getPosition();
}

public class ItemDecorator implements iItem {
    protected iItem decoratedItem;

    public ItemDecorator(iItem item){
        this.decoratedItem = item;
    }

    @Override
    public Integer getPoints() {
        return decoratedItem.getPoints();
    }

    @Override
    public Double getSpeed() {
        return decoratedItem.getSpeed();
    }

    @Override
    public Integer getY()
    {
        return decoratedItem.getY();
    }

    @Override
    public void setY(Integer y){
        decoratedItem.setY(y);
    }


    public Integer getX()
    {
        return decoratedItem.getX();
    }

    public void setX(Integer x){
        decoratedItem.setX(x);
    }

    public Entry<Integer, Integer> getPosition()
    {
        return decoratedItem.getPosition();
    }

}

class fruitDecorator extends ItemDecorator {

    public fruitDecorator(iItem fruit){
        super(fruit);
    }

    @Override
    public Integer getPoints() {
        return super.getPoints() + 1;
    }

}

public class greenFruitDecorator extends fruitDecorator{

    public greenFruitDecorator(iItem item) {
        super(item);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+500;
    }

    
}

```

#### 2. [Observer]
Nous avons utilisé le design pattern observer/observable afin que lorsque le serpent entre en contact (mange) un Item, une action soit effectuée en fonction de l'Item mangé

*Ajout de l'observer au serpent :* 
```java
public ObjetService(SnakeSingleton snakeSingleton) {
        this.instance = snakeSingleton.getInstance();
        instance.addObserver((e, f) -> DetectIfSnakeAteItem(e, f));
```

*Fonction qui compare la position du serpent à l'objet observable puis vérifie son type pour déterminer quelle action effectuer*

```java
private void DetectIfSnakeAteItem(Observable e, Object f) {
        if (f instanceof Snake) {
            var sn = ((Snake) f);
            var potentialItem = getListItems().stream()
                    .filter(o -> o.getX().equals(sn.getX()) && o.getY().equals(sn.getY())).findAny();
            if (potentialItem.isPresent()) {
                iItem item = potentialItem.get();
                getListItems().remove(potentialItem.get());

                // génération de deux valeurs aléatoires afin de définir le type d'objet qui
                // sera ajouté dans la grille

                Random random = new Random();
                
                int randomItemType;
                
                if(listCandyTypes.contains(item.getClass().getName()))
                {
                    randomItemType=0;
                }
                else {
                    randomItemType=1;
                }

                int randomItemColor = random.nextInt(4);

                generateItemsList(randomItemType, randomItemColor);

                System.out.println("L'objet " + item.getClass().getName() + " a été ramassé");
                System.out.println(getListItems());
                
                iItem iItem = (iItem) potentialItem.get();
                
                this.instance.setPoints(iItem.getPoints() * this.instance.getSpeed());
                if (iItem.getSpeed() != 0) {
                    this.instance.setSpeed(iItem.getSpeed());
                }

                sn.IncreaseSize();
            }
        }
    }
```


---

#### 3. [Singleton]

Nous avons utilisés des le design pattern singleton afin de s'assurer qu'il n'y a qu'une seule instance de la classe Snake en fournissant un point d'accès global à cette instance.

```java

import tp.Model.Snake;
@Component
public class SnakeSingleton {

    private static Snake instance;

    public SnakeSingleton(){
        SnakeSingleton.instance = new Snake(0,0);
    }
    public Snake getInstance(){
        return instance;
    }
}

```

---


# Partie pédagogique


### En quoi la POO vous a été utile

L'utilisation de la POO nous a permis de gérer facilement les différents objets ainsi que la gestion de la visibilité de certaines classes vis-à-vis d'autres. Cela a facilité la création des fruits et des bonbons en leurs passant comme attribut une position x et une position y, nous n'avons donc pas eu à les faire à la main. La programmation orientée objet permet d'effectuer de l'héritage, entrainant un principe d'encapsulation qui nous a donné la possibilité de mettre en place certains design pattern comme le pattern singleton et les décorateurs. 
La POO nous permet si nécessaire de réutiliser une classe dans plusieurs parties du projet et contribue à la modulabilité du projet
Nous avons pu utiliser des classes abstraites telles que Item qui contient les fonctions que nous utilisons pour la position des items.
Concernant le serpent, il aurait été très complexe de conserver ses données. Que ce soit au niveau de la liste des cases sur lesquelles il est et qui changent constamment, au niveau de la gestion de sa vitesse ou de son changement de direction. Le fait de pouvoir stocker toutes ces données dans un objet Snake permet l'utilisation et la modification de ces données de manière efficaces et plus simple que sans l'utilisation de la POO

### Conclusion

Les designs pattern présentés en cours avaient besoin d'être mis en application afin d'en comprendre l'utilisation dans un contexte, ce projet a été l'occasion de les travailler et d'intégrer ces nouveaux concepts.
