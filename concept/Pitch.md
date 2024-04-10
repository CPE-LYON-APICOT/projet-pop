# Pitch du projet

## TODO : Décrivez votre projet
Montrez qu'il mobilise des techniques de POO avancée
Comment allez-vous utiliser les patrons de conception ?
Comment allez-vous utiliser l'architecture MVC ?


## Description jeu
Snake avec fonctionnalités en plus (différents modes de jeu, personnalisation du serpent)

Au début affichage de la grille de jeu en console( tableau de tableaux)
plus tard grille de pixels
Possiblement affichage plus détaillé plus tard

Menu d'accueil pour :
- lancer partie
- quitter jeu
 - choisir mode de jeu / options de jeu
 - Possiblement options générales (contrôles, affichage)

Ecran de jeu qui représente la grille et ce qui est dessus


### Fonctionnalités additionnelles :

- Les bonbons font varier la vitesse du serpent
- Les fruits confèrent des points
- D'autres objets auront des effets qui leur seront propres (épée, bouclier)

## Technique
observeur grille : observer / observable
- Classe de gestion de la grille de jeu 
- certains objets peuvent apparaître sur la grille(observables) et affecter certains autres éléments(si ils sont observers)

Choix apparence / caractéristiques serpents : fabrique
- Permet de choisir des caractéristiques afin de créer différents types de serpents facilement

Level builder : builder (monteur)
- permet de facilement créer des niveaux avec différentes caractéristiques ( murs / pas de murs / forme des murs)