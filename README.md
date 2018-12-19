# Desenvolvendo o algoritimo de Dijkstra

<p align="center">
   <img src="Algoritmo_Dijkstra/Dijkstra_animation.gif" title="Animação do algoritmo de Dijkstra">
</p>

O **algoritmo de Dijkstra**, concebido pelo [cientista da computação](https://pt.wikipedia.org/wiki/Ci%C3%AAncia_da_computa%C3%A7%C3%A3o) holandês [Edsger Dijkstra](https://pt.wikipedia.org/wiki/Edsger_Dijkstra) em 1956 e publicado em 1059, soluciona o [problema do caminho mais curto](https://pt.wikipedia.org/wiki/Problema_do_caminho_mais_curto) num [grafo dirigido](https://pt.wikipedia.org/wiki/Grafo_dirigido) ou não dirigido com arestas de peso não negativo, em tempo computacional **O\(\[ m\+n \] log n\)** onde **m** é o número de arestas e **n** é o número de vértices. O algoritmo que serve para resolver o mesmo problema em um grafo com pesos negativos é o [algoritmo de Bellman-Ford](https://pt.wikipedia.org/wiki/Algoritmo_de_Bellman-Ford), que possui maior tempo de execução que o Dijkstra.

O algoritmo considera um conjunto **S** de menores caminhos, iniciado com um vértice inicial **I**. A cada passo do algoritmo busca-se nas adjacências dos vértices pertencentes a **S** aquele vértice com menor distância relativa a **I** e adiciona-o a **S** e, então, repetindo os passo até que todos os vértices alcançáveis por **I** estejam em **S**. Arestas que ligam vértices já pertencentes a **S** são desconsideradas.

Um exemplo prático do problema que pode ser resolvido pelo algoritmo de Dijkstra é:
> alguém precisa se deslocar de uma cidade para outra. Para isso, ela
> dispõe de várias estradas, que passam por diversas cidades. Qual delas
> oferece uma trajetória de menor caminho?

## Autor

> Carlos R Schwarz Jr.

