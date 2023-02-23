package matrizadj;

import System;
import System.Collections.Generic;
import System.Linq;
import System.Text;
import System.Threading.Tasks;

public class Program
{
	private static void Main(string[] args)
	{
		string[] paresVertices = System.IO.File.ReadAllLines("arquivo.txt");
		string dirigido = paresVertices[0].Substring(2, 1);

		int totalArestas = paresVertices.Count() - 1;
		int totalVertices = Convert.ToInt32(paresVertices[0].Substring(0, 1));

		int[,] matrizIncidencia = new int[totalVertices, totalArestas];
		int[,] matrizAdjacencia = new int[totalVertices, totalVertices];


		int indiceAresta = -1;


		///### matriz de adjacencia
		foreach(string par in paresVertices)
		{
			if (indiceAresta >= 0 && indiceAresta < totalArestas)
			{
				int v1 = Convert.ToInt32(par.Substring(0, 1));
				int v2 = Convert.ToInt32(par.Substring(2, 1));

				if (dirigido.equals("ND"))
				{
					matrizAdjacencia[v1 - 1, v2 - 1] = 1;
					matrizAdjacencia[v2 - 1, v1 - 1] = 1;
				}

				else
				{
					matrizAdjacencia[v1 - 1, v2 - 1] = 1;
					matrizAdjacencia[v2 - 1, v1 - 1] = 0;
				}


			}

			indiceAresta++;
		}

		Console.Write("\nPressione qualquer tecla para sair...");
		Console.ReadKey(true);

		///### matriz de incidencia
		foreach(string par in paresVertices)
		{
			if (indiceAresta >= 0 && indiceAresta < totalArestas)
			{
				int v1 = Convert.ToInt32(par.Substring(0, 1));
				int v2 = Convert.ToInt32(par.Substring(2, 1));

				matrizIncidencia[v1 - 1, indiceAresta] = 1;
				matrizIncidencia[v2 - 1, indiceAresta] = 1;

			}

			indiceAresta++;
		}
		Console.Write("\nPressione qualquer tecla para sair...");
		Console.ReadKey(true);
	}
}