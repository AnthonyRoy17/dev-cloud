
CHANUT Kévin | ROY Anthony

Voici ci-dessous le lien de notre application cloud : 
https://developpement-cloud.appspot.com/

<h1> Ce qui  marche  </h1> 

Les fonctionnalités suivantes sont implémentées :
- Liste des pétitions de la plus récente à la plus ancienne
- Liste des pétitions triées par nombre de vote
- Recherche de pétition par son nom
- Recherche de pétitions votées par un utilisateur 
- Liste des pétitions de l'utilisateur connecté et des pétitions pour lesquelles il a voté
- Vue détaillée d'une pétition
- Pagination
- Authentification Google

<h1> Ce qui ne marche pas </h1>

Malgré les fonctionnalités implémentés, nous n'avons pas réussi à réaliser correctement les points suivants :

- Ne pas faire de projections sur les StringList : lors de certaines requêtes nous n'avons pas besoins de ces listes et elles augmentent juste le temps de traitement du fait de leur grande taille. Le problème est que nous avons tout de même besoin d'une certaine quantité de champs pour afficher toutes les informations à propos des pétitions. Nous sommes donc obligés de tout afficher pour l'instant. Cela peut poser problème dans le cas où il y a beaucoup de votants, ce qui bloquerait le passage à l'échelle.
- Pagination pour les votants d'une pétition, du fait que nous récupérons les listes de votants. 
- La gestion de la concurrence n'est pas implémenté, elle est importante au cas où deux utilisateurs signent en même temps la même pétition même si cela est peu probable. Il faudrait intégrer des transactions lors des signatures.

<h1> Schéma de data </h1>

Intégrer screenshot de l'entité des petitions (screenschot des entités)

<h1> Ce qui pourrait être amélioré </h1>

Notre application est fonctionnelle dans les grandes lignes et permet de réaliser plusieurs fonctionnalités de bases. Cependant elle reste améliorable pour être plus pertinente, on pourrait par exemple :

- Intégrer un panel de pétitions en cours sur la page d'accueil
- Intégrer des images pour illustrer les pétitions
- Améliorer les recherches (Casse, élargir les résultats...)
- Permettre de trier les pétitions par type (Droits, Santé, Culture...)
- 
- Intégrer la pagination sur les onglets mes pétitions et pétitions par utilisateur
- 
- Optimiser l'application dans le cas d'une utilisation massive (voir les points dans la partie ci-dessus)


<h1> Conclusion </h1>

Ce projet était pour nous très intéressant à réaliser, c'était une bonne initiation à l'utilisation des applications CLOUD. Cela nous a permis de découvrir ce concept avec un cas concret, de plus nous avons pu y appliquer les différentes bonnes pratiques abordés durant le module. 
Une partie importante du projet consistait à se documenter sur les fonctionnalités à implémenter. Chaque fonctionnalité était affecté à une requête, qui devait être pensé pour permettre le passage à l'échelle de l'application.
Pour aller plus loin nous pourrions améliorer certaine méthodes API afin de gagner en temps de traitement. Pour passer correctement à l'échelle peut importe le nombre de votants sur les pétitions il faudrait notamment implémenter des requêtes qui ne nécessiterait pas de projection sur les StringList, chose que nous n'avons pas réussi à réaliser correctement.
  
