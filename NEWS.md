# 19 septembre 2018 : dernière ligne droite ...

Les TP encadrés sont terminés, il vous reste une séance non-encadrée
(salles réservées mais pas d'encadrants a priori) vendredi matin. Le
dernier amphi sera une présentation de
https://www.linkedin.com/in/hguemar/, employé RedHat qui vous parlera
de son expérience à grande échelle des outils que nous avons vu dans
ce cours (CI, TDD, ...).

Quelques conseils pour la suite :

* Notre dépôt a été mis à jour régulièrement, vous avez les
  instructions pour récupérer nos modifications dans votre dépôt ici :
  https://forge.univ-lyon1.fr/matthieu.moy/m1if01/blob/master/README.md#how-to-use-this-repository

* N'oubliez pas la date de rendu du TP noté ni celle de l'examen :
  https://forge.univ-lyon1.fr/matthieu.moy/m1if01/blob/master/README.md#dates-importantes
  
* N'oubliez pas de relire les consignes de rendu (qui ont évolué, cf.
  message du 17 septembre). En particulier, votre README.md doit
  impérativement indiquer l'emplacement de la dernière version de
  votre projet et du rapport :
  https://forge.univ-lyon1.fr/matthieu.moy/m1if01/blob/master/lab3-patterns/README.md#rendu-du-tp-projet
  
* Certain d'entre vous ont bien avancé sur le code de leur application
  Poneymon, mais ont oublié de suivre le sujet de TP sur les tests. Si
  vous n'avez pas suivi le lab5, il est encore temps :
  https://forge.univ-lyon1.fr/matthieu.moy/m1if01/blob/master/lab5-tests/README.md
  
* Pour la petite histoire : je vous parlais de l'importance de choisir
  son vocabulaire surtout pour un texte qui risque d'être lu en dehors
  de son contexte. J'ai été pris sur le fait dans mes slides Agilité
  où je parle du « 9 pregnant women's problem » qui a été interprêté
  comme « les femmes qui tombent enceinte, c'est un problème » !
  
* Une nouvelle petite mise à jour des slides sur les design patterns à
  propos de la classe Observable, slide 127 :
  https://perso.liris.cnrs.fr/lionel.medini/enseignement/M1IF01/CM-patterns.pdf

# 18 septembre 2018 (bis) : Petits bugs dans le sujet de TP

Comme personne n'est parfait, le sujet du TP3 et mes slides de ce
matin contiennent quelques violations des principes vus en cours.

- Il y a trop de mentions directes sur la classe ArrayList. ArrayList
  est une implémentation (tableau redimensionnable à la `std::vector` de
  C++), mais il n'y a pas de raison d'y faire référence quand on est
  utilisateur de l'objet : on le manipule via son interface `List`.
  Sinon on dépend d'un détail d'implémentation et on viole au moins le
  le D de SOLID.

- La partie MVC décrit une « interface » dont le nom est
  « AbstractView ». C'était une erreur de nommage : le préfixe
  « Abstract » implique qu'il s'agit d'une classe abstraite (qui
  aurait pu contenir autre choses que des méthodes abstaites), alors
  qu'il s'agit bien d'une interface. « View » aurait été un bien
  meilleur nom.

- Les noms de packages suggérés utilisent des majuscules (« Model »,
  « View », « Controler »), c'est contraire aux coding style Java. Il
  faudrait utiliser des minuscules.
  
Le sujet a été mis à jour. Nous vous recommandons de mettre à jour
votre code (avec les outils de refactoring de votre IDE, c'est
faisable en quelques minutes).

# 18 septembre 2018 : Observateur et Java

Suite à une discussion en TP, Lionel Medini a ajouté un slide (n°127)
au CM Design patterns sur le pattern Observer :

* Utilisation en Java :
  - Les classes java.util.Observer et java.util.Observable sont dépréciées depuis avril 2016
  - notifyObservers() pas assez précise (pas de paramètre)
  - Implémentation non thread-safe

* Cela ne signifie pas que le pattern est déprécié
  - Utiliser votre propre implémentation (plus précise) si besoin
  - Utiliser les files et sémaphores (java.util.concurrent) avec des threads

Source : https://bugs.openjdk.java.net/browse/JDK-8154801
Slides à jour : https://perso.liris.cnrs.fr/lionel.medini/enseignement/M1IF01/CM-patterns.pdf

# 17 septembre 2018 : Dates importantes (examen, rendu TP)

Il y avait une petite erreur dans mes slides du premier cours (date incohérente avec la date de rendu du TP). Par ailleurs, nous venons de planifier l'examen. Voici donc les dates :

* Rendu du TP : dimanche 30 septembre 2018 à 23h59. A cette date vous devrez avoir fourni l'URL de votre rendu sur TOMUSS (vous pouvez le faire dès maintenant), et vous ne devez plus modifier le contenu de la branche 'master' de votre projet.

* Examen : Jeudi 11 octobre 2018, Amphi Thémis 11, 14h - 15h30. L'examen dure 1h30 sauf pour les tiers-temps qui auront 2h. L'amphi est réservé à partir de 13h30 dans ADE mais l'examen démarrera à 14h.

Par ailleurs, merci de noter que nous avons mis à jour les consignes :

* Le barème du TP noté : https://forge.univ-lyon1.fr/matthieu.moy/m1if01/tree/master/lab3-patterns#bar%C3%AAme-indicatif-sur-30-remis-sur-20

* Les consignes pour l'examen : https://forge.univ-lyon1.fr/matthieu.moy/m1if01/blob/master/README.md#dates-importantes

# 15 septembre 2018 : N'oubliez pas de former vos binômes

Si vous recevez ce message c'est que vous n'avez pas encore constitué votre binôme sur TOMUSS.

Vous devrez travailler en binôme à partir de lundi (après-demain), donc ne tardez pas à le faire. Pour rappel :

3) A partir de lundi prochain, nous vous demandons de travailler en binôme. Nous ferons éventuellement un monôme en cas de nombre d'étudiants impair. Pour choisir votre binôme :

   - Mettez-vous d'accord avec un autre étudiant pour travailler en binôme si ce n'est pas déjà fait.
   - Choisissez un nom pour votre binôme. Il doit être unique (par exemple le numéro d'étudiant de l'un de vous, la sortie de la commande uuidgen, l'URL de votre dépôt privé ...)
   - Sur https://tomuss.univ-lyon1.fr/, chaque étudiant du binôme entre le nom du binôme dans la case « Binôme » qui doit apparaître sur votre feuille de suivi. Les deux étudiants doivent saisir la même valeur.
   - Vous pouvez dès à présent entrer l'URL du dépôt de votre rendu dans TOMUSS (https://forge.univ-lyon1.fr/p....../m1if01). Nous vous le rappellerons au prochain TP.
