# TP3 - Design patterns

Objectifs
------------

Il vous est demandé d’effectuer une ré-ingénierie d’un code existant en mettant en oeuvre les patrons de conception vus en cours.

### Déroulement

Ce TP est organisé en deux étapes :

- une ré-ingénierie (refactoring) du code utilisé dans les premiers TP afin de mieux structurer le projet et de le rendre plus modulaire,
- l’extension des fonctionnalités pour réaliser un jeu plus complet.

### Base de code et méthode

Le projet dont vous partirez pour ce TP doit comprendre les éléments suivants :

- structure et configuration Maven
- .gitignore
- checkstyle.xml
- les 3 classes initiales et les assets donnés dans les TPs 1 & 2
- les extensions demandées au TP1 (super poneys, stratégie)
- le test fourni au TP2

Vous pouvez soit cloner votre projet et réaliser le TP3 en le refactorant, soit créer un nouveau projet Maven et travailler "from scratch", en y important les éléments ci-dessus  au fur et à mesure de votre refactoring.

### Ressources

- [Cours (et pointeurs à la fin du cours) sur les Design patterns](https://perso.liris.cnrs.fr/lionel.medini/enseignement/M1IF01/CM-patterns.pdf)
- [Aide à la mise en place du pattern MVC pour ce TP](./mvc.md)

Consignes
--------------

**Votre travail devra être rendu sous forme d’un projet déposé sur la Forge Lyon 1, au plus tard le dimanche 30 septembre 2018 à 23h59.**

Il est demandé de travailler en binômes.

Penser à remplir dès à présent TOMUSS pour indiquer le nom de votre binôme et votre dépôt forge. *Cf*. instructions ci-dessous.

### Qualité du code

Le but de ce cours en général est de vous apprendre à écrire du code propre (irréprochable ?). 
On accordera une attention particulière à la qualité du code à tous les niveaux (style, indentation, architecture...). 
Privilégiez la qualité du code à la quantité de fonctionalités.

Partie 1 : Ré-ingénierie
------------------------------

Le code fourni lors de la première séance est un package relativement fouillis.
Toutes les classes sont dépendantes les unes des autres, les couches graphique et métier ne sont pas séparées.
Il va vous falloir réorganiser le code en appliquant les patrons de conception adéquats.

### Patterns GRASP

Commencez par passer l'application au crible des 4 premiers patterns GRASP présentés dans le cours (expert, créateur, faible couplage, forte cohésion).
Au besoin, déplacez les éléments entre les classes, et servez-vous des 4 suivants (indirection, fabrication pure, protection des variations, polymorphisme) pour rendre votre code plus robuste et facilement maintenable.

Cette étape ne doit pas durer plus de 20 minutes. Ne vous préoccupez pas pour l'instant du pattern contrôleur, ni du mélange entre métier et vue.

**Vous décrirez dans votre rapport les modifications que vous avez choisi de faire, et les justifierez.**

### Pattern Modèle-Vue-Contrôleur

Vous allez maintenant redéfinir la structure de base de l’application.
Mettez en place un pattern MVC pour :

- séparer le métier et l’affichage des éléments (poneys, stratégies, etc.)
- propager les changements du modèle métier (déplacements, mode NianPoney...) dans la vue
- répercuter les entrées utilisateur (clavier ou souris) sous la forme adéquate dans le modèle métier

Pour vous aider, vous pouvez utilier les slides du cours sur les patterns contrôleur (69 à 77) et MVC (140 à 146), ainsi que le document [Mettre en place le pattern MVC](mvc.md). Ce document propose des questions pertinentes à se poser, ainsi que quelques éléments de réponses, mais ce ne sont ni les seules questions ni les seules réponses pertinentes.

**Pour chacun des patterns implémentés à partir de cette partie, décrirez (en 1 §) pourquoi vous avez choisi de l'utiliser, et vous fournirez dans votre rapport un/des diagramme(s) UML illustrant comment vous l'avez mis en oeuvre.**


#### Flexibilité du modèle MVC

**Plusieurs vues identiques**

Une des propriétés du MVC est qu'on peut avoir un nombre quelconque de vues, identiques ou non, d'un modèle donné. 
On peut vérifier simplement que notre MVC vérifie cette propriété en ajoutant quelque chose comme ceci dans le programme principal :

```java
// Secondary view
Stage s2 = new Stage();
JfxView v2 = new JfxView(s2, 5, 1000, 600);
c.addView(v2);
v2.setModel(m);
v2.setControler(c);
```

Vous devriez voir une deuxième fenêtre, de taille différente, qui affiche le jeu. 
Les deux fenêtres doivent être synchronisées : le temps mis par un poney pour parcourir l'écran est constant.

Remarque : si la deuxième fenêtre vous gêne, mettez en commentaire le morceau de code concerné, mais conservez-le et vérifier qu'il marche toujours au moment du rendu.

**Vue "poney"**

Créez maintenant une seconde vue qui n'affiche que les informations relatives au poney 1 (nom, position, vitesse, mode...). 
Cette vue doit s'afficher en plus de la vue principale. Vous pouvez au choix utiliser une seconde fenêtre graphique (de préférence) ou l'affichage texte via `System.out`.

Bonus : faites en sorte que cette vue change de "cible" quand on clique sur (ou si on sélectionne) un autre poney.

### Autres patterns

Reprenez les transparents du cours et parcourez la liste des patterns GRASP, des patterns de création, de structure, des principes SOLID, et posez-vous la question de l'applicabilité sur votre projet.
Appliquez ceux qui vous semblent pertinents, et de la même façon que précédemment, documentez cela dans votre rapport (si possible, en suivant la progression du cours : GRASP, création, structure...).

### Anticiper sur le TP 5 "test"

Avant d'aller plus loin sur les extensions, c'est une bonne idée de progresser en tests : nous serons plus en sécurité pour continuer le refactoring et les extensions avec une bonne base de tests. 
Allez jeter un œil au [TP "Test"](../lab5-test/README.md) (en particulier la section sur le TDD), et revenez pour la suite de ce TP après. 
A vous de voir dans quel ordre vous voulez avancer précisément.

Partie 2 : Extension
-------------------------

Dans toute cette partie, l'ajout de fonctionnalité est un prétexte pour se servir de design patterns. 
Ajoutez chaque fonctionnalité en appliquant les principes et patterns vus en cours, et justifiez-le dans le rapport.

### Boutons pour contrôler le jeu

On commencera par ajouter des éléments de contrôle au jeu pour le faire démarrer, le mettre en pause, etc. 
On utilisera pour cela des widgets JavaFX tels que des boutons. 
Il n'est pas demandé de faire une interface « jolie » : concentrez-vous sur le fond.

Un moyen simple d'ajouter une barre de boutons en haut de l'écran est d'ajouter ceci après `root.getChildren().add(field);` :

```java
HBox hb = new HBox(); // Boite où ranger les éléments horizontalement

Button hello = new Button("Say hello");
hello.setOnMouseClicked(new EventHandler<MouseEvent>() {
	public void handle(MouseEvent arg0) {
		System.out.println("Hello");
	}
});

Button goodBye = new Button("Say good bye");
goodBye.setOnMouseClicked(new EventHandler<MouseEvent>() {
	public void handle(MouseEvent arg0) {
		System.out.println("Good bye");
	}
});

hb.getChildren().add(hello);
hb.getChildren().add(goodBye);
root.getChildren().add(hb);
```

Vous devez avoir au minimum :

* Des boutons pour activer le mode "boost" des poneys gérés manuellement.
* Un bouton pour mettre le jeu en pause
* Un bouton pour relancer le jeu quand il est en pause (qui peut être le même que le bouton pause).

### Intelligence artificielle

Assurez-vous que l'intelligence artificielle est bien intégrée et fonctionne toujours dans votre programme MVC [(voir fin du TP remise en route Java)](../lab1-java/).

### Ajouter des règles

A vous de jouer pour la suite : vous pouvez ajouter d'autres types de coureurs que les Poneys (pourquoi pas des crocodiles qui avanceraient plus doucement mais croqueraient les poneys qui s'aventureraient trop près d'eux sans courir assez vite ?), des pièces bonus à ramasser pour prolonger/augmenter le boost, des possibilités de tacler les poneys suffisament proches...

Rendu du TP / projet
---------------------------

**Votre travail devra être rendu sous forme d’un projet déposé sur la Forge Lyon 1, au plus tard le dimanche 30 septembre 2018 à 23h59.**

### Qualité du code

#### Style

Assurez-vous que votre programme respecte toujours le style imposé (`mvn test`)

#### Intégration continue

Vérifiez que l'intégration continue mise en place au [TP2](../lab2-tools) fonctionne toujours

#### Portabilité

Clonez, compilez et exécutez votre code **sur une machine vierge** (c'est-à-dire sur laquelle vous n'avez installé aucune dépendance, ni configuré le compte utilisateur de façon particulière). Une grande partie du barème est liée à l'exécution de votre travail. Il est important que nous arrivions à l'exécuter **directement**. "Ca marche chez moi" n'est pas une excuse et une démo *a posteriori* ne permet pas de remonter une note de TP.

### Projet Forge et questionnaire

Les projets seront rendus en binômes. 
Les autres cours vont arriver très vite, il est conseillé d’avoir presque terminé le week-end suivant le TP.


**Ajoutez Matthieu MOY, Lionel MEDINI et Fabien RICO en tant que “reporters”.**

Pensez à remplir dès à présent TOMUSS indiquant votre binome et votre dépôt forge. 
Le dépot ne sera relevé qu’après la date de rendu.

Votre dépôt sur la Forge devra contenir :

-   un fichier `README.md` (ou `.txt`) à la racine du projet
-   un fichier maven (`pom.xml`) pour le build du projet
-   les sources (fichiers Java)
-   la documentation javadoc de vos classes
-   les fichiers natifs de votre modélisation UML (indiquez quel outil a
    été utilisé)
-   le rapport en PDF (6 pages maximum, format libre).

Le rapport doit comprendre une présentation globale du projet, une motivation des choix d’architecture (et des patterns choisis), et leur explication en s’aidant de diagrammes appropriés et adaptés au degré de précision et au type d’explication. 
Donc des diagrammes de classe, mais pas que cela, et pas de plats de spaghettis générés automatiquement représentant tout le code.

### Barême indicatif (sur 27, remis sur 20)

-   Réalisation et exécution : 18 points
    -   Clone git qui fonctionne (les bonnes personnes sont rapporteurs,
        la bonne branche est indiquée dans TOMUSS) (0,5 pts)
    -   Compilation Maven (1 pts)
    -   Code qui tourne directement sur l’ordinateur de l’évaluateur (1
        pts)
    -   Qualité du code (2 pts)
    -   Structure globale du code, utilisation de Packages (0,5 pts)
    -   README et respect des consignes (1 pts)
    -   Interface (UI) propre (1 pts)
    -   Stratégies **simples** implémentées (2 pts)
    -   Gestion des tirs / touchés (1 pts)
    -   Tests (3 pts)
    -   Patterns mis en oeuvre (3 pts)
-   Rapport et modélisation : 9 points
    -   Qualité de la réalisation Patterns utilisés (MVC est
        obligatoire + 3 autres minimums) (3pts)
    -   Modélisation des parties clés de l’application (3pts)
    -   Explications (3pts)
    -   Les points suivants entrainent des malus (jusqu’à -5 pts)
        -   Contenu et forme (voir ci-dessus)
        -   Orthographe
