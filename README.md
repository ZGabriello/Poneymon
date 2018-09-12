# Gestion de Projet et Génie Logiciel, M1, département informatique, Lyon 1

## Course 1: Introduction

* [01-introduction-slides.pdf](01-introduction-slides.pdf)
  (printable version: [01-introduction-handout.pdf](01-introduction-handout.pdf))
  
## Lab 1: Java Warm Up

* [lab1-java/README.md](lab1-java/README.md)

## Course 2: Build tools, dependency management, forge

* [02-cm-maven-forge-ic-slides.pdf](02-cm-maven-forge-ic-slides.pdf)
  (printable version: [02-cm-maven-forge-ic-handout.pdf](02-cm-maven-forge-ic-handout.pdf))

## Lab 2: 

* [lab2-tools/README.md](lab2-tools/README.md)

## Course 3: Coding style and use-cases

* [03-coding-style-slides.pdf](03-coding-style-slides.pdf)
  (printable version: [03-coding-style-handout.pdf](03-coding-style-handout.pdf))

* [04-UML-CU.pdf](04-UML-CU.pdf)

## Tutorial 1: Use-cases and coding style

* [tuto1-uc-style/TD_UseCaseFffound_et_style.pdf](tuto1-uc-style/TD_UseCaseFffound_et_style.pdf)
  (corrected version : [tuto1-uc-style/TD_UseCaseFffound_et_style_correction.pdf](tuto1-uc-style/TD_UseCaseFffound_et_style_correction.pdf))

## Course 4: Agile

## Tutorial 2: Paper4Scrum

## Course 5: Design-patterns

* Slides : [CM-patterns.pdf](https://perso.liris.cnrs.fr/lionel.medini/enseignement/M1IF01/CM-patterns.pdf)

## Lab 3 & 4: design patterns & refactoring

* [lab3-patterns/README.md](lab3-patterns/README.md) and some help
  with [MVC](lab3-patterns/mvc.md)

## Lab 5: tests

* [lab5-tests/README.md](lab5-tests/README.md)

# How to use this repository

This repository contains course material and code skeletons. The
recommended way to use it is:

* Fork the project from
  https://forge.univ-lyon1.fr/matthieu.moy/m1if01 and make it private.
  
* Clone your fork and work in the fork.

To get updates from the teacher's repository, run once :

    git remote add moy https://forge.univ-lyon1.fr/matthieu.moy/m1if01.git

Then, each time you want to fetch updates, run :

    git pull moy master

This downloads and applies changes made by the teachers. You can keep
working as usual with your private repository. In summary:

    git pull            # get changes from your private fork (i.e. your co-worker)
	git push            # send changes to your private fork
	git pull moy master # get updates from teachers
