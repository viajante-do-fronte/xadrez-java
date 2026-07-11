package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat [i][j] = (PecaXadrez) tabuleiro.peça(i, j);
			}
		}
		return mat;
	}
	
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoAlvo) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao alvo = posicaoAlvo.toPosicao();
		validarPosicaoOrigem(origem);
		Peca pecaCapturada = fazMovimento(origem, alvo);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca fazMovimento(Posicao origem, Posicao alvo) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(alvo);
		tabuleiro.colocaPeca(p, alvo);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Não a peça na posição de origem");
		}
	}
	
	private void colocarPecaNova(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocaPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void setupInicial() {
		colocarPecaNova('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarPecaNova('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarPecaNova('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarPecaNova('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarPecaNova('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarPecaNova('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		colocarPecaNova('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarPecaNova('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarPecaNova('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarPecaNova('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarPecaNova('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarPecaNova('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}

