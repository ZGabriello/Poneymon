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
