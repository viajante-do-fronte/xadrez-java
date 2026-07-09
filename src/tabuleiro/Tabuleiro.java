package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
    private Peca[][] pecas;
    
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("erro ao criar tabuleiro: ele deve conter mais de 1 linha ou 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}


	public int getColunas() {
		return colunas;
	}
	
	public Peca peça(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("posição não não esta no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peça (Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("posição não não esta no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];	
	}
	
	public void colocaPeca(Peca peca, Posicao posicao) {
		if(temUmaPeca(posicao)) {
			throw new TabuleiroException("já exite uma peça na posição: " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private Boolean posicaoExiste (int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public Boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("posição não existe");
		}
		return peça(posicao) != null;
	}

}
