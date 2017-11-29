public void selecao(int i)
{
	for(int i =0; i < (n-1). i++)
	{
		int menor = i;
		for(int j = i+1; j < n; j++)
		{
			if(array[menor] > array[j])
			{
				menor =j;
			}
		}
		if(array[menor] < array[i])
		{
			int aux = array[i];
			array[i] = array[menor];
			array[menor] = aux;
		}
	}
}

public void insercao()
{
	for(int i =1; i < n ; i++)
	{
		int tmp = array[i];
		int j = i-1;
		if((j >= 0) && array[j] < tmp)
		{
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = tmp;
	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//ARVORE BINARIA

class No
{
	public int elemento;
	public No dir, esq;

	public No(int elemento){this(elemento, null, null);}

	public No(int elemento, No dir, No esq)
	{
		this.elemento = elemento;
		this.dir = dir;
		this.esq = esq;
	}
}

class Arvore
{
	public No raiz;

	public No Arvore()
	{
		this.raiz = null;
	}

	public void inserir(int x)
	{
		this.raiz = inserir(x, this.raiz);
	}

	public No inserir(int x, No i)
	{
		if(i == null)
		{	
			i = new No(x);
		}else if(x < i.elemento){
			i.esq = inserir(x, i.esq);
		}else if(x > i.elemento){
			i.dir = inserir(x, i.dir);
		}else{
			throw new Exception("ERROR");
		}
	}

	public boolean pesquisar(int x)
	{
		return pesquisar(x, this.raiz);
	}

	public boolean pesquisar(int x, No i)
	{
		boolean resp;
		if(i == null)
		{
			resp = false;
		}else if(x == i.elemento){
			resp = true;
		}else if(x < i.elemento){
			resp = pesquisar(x, i.esq);
		}else{
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	public void remover(int x)
	{
		this.raiz = remover(x, this.raiz);
	}

	public No remover(int x, No i)
	{
		if(i == null)
		{
			throw new Exception("ERROR");
		}else if(x < i.elemento){
			i.esq = remover(x, i.esq);
		}else if(x > i.elemento){
			i.dir = remover(x, i.elemento);
		}else if(i.dir == null){
			i = i.esq;
		}else if(i.esq == null){
			i = i.dir;
		}else{
			i.esq = anterior(i, i.esq);
		}
		return i;
	}

	public No anterior(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = anterior(i, j.dir);
		}else{
			i.elemento = j.elemento;
			j = j.esq;
		}
		return j;
	}
}
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//ARVORE ARVORE

class No
{
	public int elemento;
	public No dir, esq;
	public No2 arvore;

	public No(int elemento){this(elemenot, null, null, null);}
	public No(int elemento, No dir, No esq, No2 no)
	{
		this.elemento = elemento;
		this.dir = dir;
		this.esq = esq;
		this.arvore = arvore;
	}
}

class No2
{
	public int num;
	public No2 dir, esq;

	public No2(int num){this(num, null, null);}

	public No2(int num, No2 dir, No2 esq)
	{
		this.num = num;
		this.dir = dir;
		this.esq = esq;
	}
}

class ArvoreArvore
{
	public No raiz;

	public ArvoreArvore()
	{
		this.raiz = null;
	}

	public void inserir(int x)
	{
		this.raiz = inserir(x, this.raiz);
	}	

	public No inserir(int x, No i)
	{
		if(i == null)
		{	
			i = new No(x);
		}else if(x < i.elemento){
			i.esq = inserir(x, i.esq);
		}else if(x > i.elemento){
			i.dir = inserir(x, i.elemento);
		}else{
			throw new Exception("ERROR");
		}
	}

	public void inserir2(int x)
	{
		inserir(x, this.raiz);
	}

	public void inserir2(int x, No i)
	{
		if(x == i.elemento)
		{
			boolean parar = false;
			No2 j = i.arvore;
			while(!parar)
			{
				if(j == null)
				{
					j = new No2(x);
					parar = true;
				}else if(x < j.num){
					j = j.esq;
				}else if(x > j.num){
					j = j.dir;
				}else{
					throw new Exception("ERROR");
				}
			}
		}else if(x < i.elemento){
			i.esq = inserir2(x, i.esq);
		}else if(x > i.elemento){
			i.dir = inserir2(x, i.dir);
		}else{
			throw new Exception("ERROR!");
		}
	}

	public boolean pesquisar(int x)
	{
		return pesquisar(x, this.raiz);
	}

	public boolean pesquisar(int x, No i)
	{
		boolean resp;
		if(i == null)
		{
			resp = false;
		}else if(x == i.elemento){
			resp = pesquisar2(x, i.arvore);
		}else if(x < i.elemento){
			i.esq = pesquisar(x, i.esq);
		}else if(x > i.elemento){
			i.dir = pesquisar(x, i.dir);
		}
		return resp;
	}


	public boolean pesquisar2(int x, No2 i)
	{
		boolean resp;
		if(i == null)
		{
			resp = false;
		}else if(x == i.num){
			resp = true;
		}else if(x > i.num){
			resp = pesquisar2(x, i.dir);
		}else if(x < i.num){
			resp = pesquisar2(x, i.esq);
		}
		return resp;
	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Arvore AVL

class No
{
	public int valor;
	public No esq, dir;
	public int nivel;

	public No(int valor){this(valor, null, null, 1);}
	public No(int valor, No esq, No dir, int nivel)
	{
		this.valor = valor;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}

	public No seNivel()
	{
		this.nivel = 1 + Math.max(getNivel(this.esq), getNivel(this.dir));
		return this;
	}

	public static int getNivel(No i)
	{
		return (i == null) ? 0 : i.nivel; 
	}
}

class AVL
{
	private No raiz;

	public AVL()
	{
		this.raiz = null;
	}

	public in getAltura()
	{
		return nivel(this.raiz) - 1;
	}

	private int nivel(No i)
	{
		return (i == null) ? 0 : (1 + Math.max(nivel(i.esq), nivel(i.dir)))
	}

	public boolean pesquisar(int valor)
	{
		return pesquisar(valor, this.raiz);
	}

	public boolean pesquisar(int valor, No i)
	{
		boolean resp;

		if(i == null)
		{
			resp = false;
		}else if(valor == i.valor){
			resp = true;
		}else if(valor < i.valor){
			i.esq = pesquisar(valor, i.esq);
		}else{
			i.dir = pesquisar(valor, i.dir);
		}
	}

	public void inserir(int valor)
	{
		this.raiz = inserir(valor, this.raiz);
	}

	public void inserir(int x, No i)
	{
		//igual ao da arvore binaria ..
		
		i = balancear(i);

		return i;
	}

	public void remover(int valor)
	{
		this.raiz = remover(valor, this.raiz);
	}

	public void remover(int x, No i)
	{
		//igual ao da arvore binaria
		
		i = balancear(i);

		return i;
	}

	public void anterior(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = anterior(i, j.dir);
		}else{
			i.elemento = j.elemento;
			j = j.esq;
		}
	}

	/*private No balancear(No i)
	{
		if(i != null)
		{
			int fator = No.getNivel(i.dir) - i.getnivel(i.esq);

			if(Math.abs(fator) <= 1)
			{
				i = i.setNivel();
			}else if(fator == 2){
				int fatorFilhoDir = No.getNivel(i.dir.dir) - No.getNivel(i.dir.esq);

				if(fatorFilhoDir == -1)
				{
					no.dir = rotacionarDir();
				}	
			}
		}
	}*/

	private No rotacionarDir(No i)
	{
		No noEsq = i.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = i;
		i.esq = noEsqDir;

		i.setNivel();
		noEsq.setNivel();

		return noEsq;
	}

	private No rotacionarEsq(No i)
	{
		No noDir = i.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = i;
		i.dir = noDirEsq;

		i.setNivel();
		noDir.setNivel();

		return noDir;
	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Arvore Alvinegra

class Alvinegra
{
	private No raiz;

	public Alvinegra()
	{
		this.raiz = null;
	}

	//pesquisar igual ao da arvore binaria
	public void inserir()
	{

	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Matriz Dinamica

class Celula
{
	public int valor;
	public Celula esq, dir, sup, inf;

	public void Celula(int x){this(x, null, null, null, null)}
	public void Celula(int x, Celula sup, Celula inf, Celula esq, Celula dir, int linha, int coluna)
	{
		this.valor = x;
		this.sup = sup;
		this.inf = inf;
		this.esq = esq; 
		this.dir = dir;
	}
}

class Matriz
{
	public Celula inicio;
	public linha, coluna;
	public Celula m, n; //ponteiros auxiliares

	public Matriz(){this(0,0);}
	public Matriz(int lin, int col)
	{
		this.inicio = new Celula(0);
		this.linha = lin;
		this.coluna = col;
		gerarMatriz(col, lin);
		this.m = this.n = this.inicio;
	}

	public void gerarMatriz()
	{
		if(coluna < 0 || linha < 0)
		{
			throw new Exception("ERROR!");
		}

		int col = 0;
		int lin = 0;

		while(lin < this.linha)
		{
			while(col < this.coluna-1)
			{
				j.dir = new Celula(0);
				j = j.dir.esq;
				j = j.dir;

				if(j.esq != null && j.esq.sup != null)
				{
					j.sup = j.esq.sup.dir;
					j.esq.sup.dir.inf = j;
				}
				col++;
			}

			i.inf = new Celula(0);
			i.inf.sup = i;
			i = j = i.inf;
			col = 0;
			lin++;
		}
	}

	public void inserir(int valor)
	{
		if(this.tam == (this.linha * this.coluna))
		{
			throw new Exception("ERROR");
		}

		if(this.n.dir != null)
		{
			this.n.valor = valor;
			this.n = this.n.dir;
		}else{
			this.n = this.m.inf;
			this.n.valor = valor;
			this.m = this.m.inf;
		}
	}

	public boolean pesquisa(int x)
	{
		boolean resp = false;
		for(Celula i = this.inicio; i != null; i = i.inf)
		{
			for(Celula j = i; j != null; j = j.dir)
			{
				if(x == j.valor)
				{
					resp = true;
				}
			}
		}
		return resp;
	}

	public int soma()
	{
		if(this.linha != this.coluna)
		{
			throw new Exception("ERROR!");
		}	

		int soma =0;
		for(Celula i = this.inicio; i != null; i = i.inf)
		{	
			for(Celula j = i; j != null; j = j.dir)
			{
				soma += j.valor;
			}
		}

		return soma;
	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Hash Direta com Reserva	

class Hash
{
	public int[] array;
	int m1, m2, m, reserva;
	int NULO = -1;

	public Hash()
	{
		this(10, 5);
	}

	public Hash(int m1, int m2)
	{
		this.m1 = m1;
		this.m2 = m2;
		this.m = m1 + m2;

		this.array = new int[this.m];

		for(int i = 0; i < this.array.length; i++)
		{
			this.array[i] = NULO;
		}
		reserva = 0;
	}

	public int hash(int valor)
	{
		return valor % this.m1;
	}

	public boolean inserir(int valor)
	{
		boolean resp = false;

		if(valor != NULO)
		{
			int pos = hash(valor); //posicao a ser inserido na tabela
			if(array[pos] == NULO)
			{
				array[pos] = valor;
				resp = true;
			}else if(reserva < m2){
				array[m1 + reserva] = valor;
				reserva++;
				resp = true;
			}	
		}
		return resp;
	}

	public boolean pesquisa(int valor)
	{
		boolean resp = false;

		int pos = hash(valor);

		if(array[pos] == valor)
		{
			resp = true;
		}else{
			for(int i =0; i < reserva; i++)
			{
				if(tabela[m1+i] == valor)
				{
					resp = true;
					i = reserva;
				}
			}
		}
		return resp;
	}
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//HASH com ReHash

class HashReHash
{
	public int[] array;
	public int m;
	public int NULO = -1;

	public HashReHash(){this(10);}
	public HashReHash(int m)
	{
		this.m = m;
		this.array = new int[this.m];
		for(int i =0; i < this.array.length; i++)
		{
			this.array[i] = NULO;
		}
	}

	 public int hash(int valor)
	 {
	 	return valor % this.m;
	 }

	 public int reHash(int valor)
	 {
	 	return ++valor % this.m;
	 }

	 public boolean inserir(int valor)
	 {
	 	boolean resp = false;

	 	if(valor != NULO)
	 	{
	 		int pos = hash(valor);
	 		if(this.array[pos] == NULO)
	 		{
	 			this.array[pos] = valor;
	 			resp = true;
	 		}else{
	 			pos = reHash(valor);
	 			if(this.array[pos] == NULO)
	 			{
	 				this.array[pos] = valor;
	 				resp = true;
	 			}
	 		}
	 	}
	 	return resp;
	 }

	 public void pesquisar(int valr)
	 {
	 	boolean resp = false;
	 	int pos = hash(valor);

	 	if(this.array[pos] == valor)
	 	{	
	 		resp = true;
	 	}else{
	 		pos = reHash(valor);
	 		if(this.array[pos] == valor)
	 		{
	 			resp = true;
	 		}
	 	}
	 	return resp;
	 }
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Estrutura doidona

class Doidona
{
	private int t1[];
	private int t3[];
	private No raizT3;
	private No raizT2;
	private Celula primeiroT2, ultimoT2;

	private int tamT1 = 10;
	private int tamT3 = 11;
	private int NULO = -1;

	public Doidona()
	{
		t1 = new int[tamT1];
		t3 = new int[tamT3];
		for(int i =0; i < tamT1; i++)
		{
			t1[i] = NULO;
		}

		for(int i =0; i < tamT3; i++)
		{
			t3[i] = NULO;
		}

		this.raizT2 = this.raizT3 = null;
		this.primeiroT2 = this.ultimoT2 = new Celula();

		public int hashT1(int x)
		{
			return x % tamT1;
		}

		public int hashT2(int x)
		{
			return x % 3;
		}

		public int hashT3(int x)
		{
			return x % tamT3;
		}

		public int reHashT3(int x)
		{
			return ++x % tamT3;
		}

		public void inserir(int x)
		{
			if(x == NULO)
			{
				//erro
			}else if(t1[hashT1(x)] == NULO){
				t1[hashT1(x)] = x;
			}else if(hashT2(x) == 0){
				if(t3[hashT3(x)] == NULO)
				{
					t3[hash(x)] = x;
				}else if(t3[reHash(x)] == NULO){
					t3[reHash(x)] = x;
				}else{
					inserir(this.raizT3, x);
				}
			}else if(hashT2(x) == 1){
				inserir(primeiroT2, ultimoT2, x);
			}else{
				inserir(this.raizT2, x);
			}
		}

		public void inserir(No i, int elemento)
		{
			if(i == null)
			{
				i = new No(elemento);
			}else if(elemento < i.elemento){
				i.esq = inserir(i.esq, elemento);
			}else{
				i.dir = inserir(i.dir, elemento);
			}
		}

		public void inserir(Celula primeiro, Celula ultimo, int x)
		{
			ultimo.prox = new Celula(x);
			ultimo = ultimo.prox;
		}

	public boolean pesquisar(int valor)
	{
      boolean resp = false;

      int pos = hashT1(valor);

      if(t1[pos] == valor){
         resp = true;

      }else {
         pos = hashT2(valor);

         if (pos == 0){
            pos = hashT3(valor);
            if(t3[pos] == valor){
               resp = true;
            }else{
               pos = rehashT3(valor);
               if(t3[pos] == valor){
                  resp = true;
               }else{
                  resp = arvoreT3.pesquisar(valor);
               }

            }
         }else if (pos == 1){
            resp = lista.pesquisar(valor);
         } else {
            resp = arvoreT2.pesquisar(valor);
         }
      }
      return resp;
   }
}

/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/
/*------------------------------------------------------------------------*/

//Arvore TRIE

class No
{
	public char elemento;
	public int tam = 255;
	public No[] prox;
	public boolean folha;

	public No(){this(' ');}
	public No(char x)
	{
		this.elemento = x;

		this.prox = new No[tam];

		for(int i =0; i < tam; i++)
		{
			this.prox[i] = null;
		}

		this.folha = false;
	}

	public static int hash(char x)
	{
		return (int)x;
	}
}

class ArvoreTrie
{
	private No raiz;

	public ArvoreTrie()
	{
		this.raiz = new No();
	}

	public void inserir(String s)
	{	
		inserir(s, this.raiz, 0);
	}

	public void inserir(String s, No i, int x)
	{
		if(i.prox[s.charAt(i)] == null)
		{
			i.prox[s.charAt(i)] = new No(s.charAt(i));

			if(i == s.length()-1)
			{
				no.prox[s.charAt(i)].folha = true;
			}else{
				inserir(s, i.prox[s.charAt(i)], i+1);
			}
		}else if(i.folha == false]){
			inserir(s, i.prox[s.charAt(i), i+1])
		}else{
			throw new Exception("ERROR");
		}
	}

	public boolean pesquisar(String s)
	{
		return pesquisar(s, this.raiz, 0);
	}

	public boolean pesquisar(String s, No i, int x)
	{
		boolean resp;

		if(i.prox[s.charAt(i)] == null)
		{
			resp = false;
		}else if(i == s.length()-1){
			resp = (i.folha == true)
		}else if(i < s.length()-1){
			resp = pesquisar(s, i.prox[s.charAt(i)], i+1);
		}else{
			throw new Exception("ERROR");
		}

		return resp;
	}

	public void mostrar()
	{
		mostrar("", this.raiz)
	}

	public void mostrar(String s, No i)
	{
		if(i.folha == true)
		{
			System.out.println(s+i.elemento);
		}else{
			for(int i =0; i < i.prox.length; i++)
			{
				if(i.prox[i] != null)
				{
					// System.out.println(i.elemento+ " " +i.prox[i].elemento);
					mostrar(s+i.elemento, i.prox[i]);
				}
			}	
		}
	}
}
