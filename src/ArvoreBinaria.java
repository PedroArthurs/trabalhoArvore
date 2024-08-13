public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No (valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        }else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                }else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            }else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return  this.raiz;
    }

    public void remFolha( int valor) {

        No atual = this.raiz;
        No pai = null;

        //Enquanto não encontro o no
        while(atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else {
                atual = atual.getDir();
            }
        }
        //Se o no não existir
        if (atual == null ) {
            System.out.println("O nó com o valor " + valor + " não existe");
            return;
        }

        // Verifica se o nó é uma folha
        if(atual.getEsq() == null && atual.getDir() == null) {
            // Se o nó é a raiz
            if(atual == this.raiz) {
                this.raiz = null;
            }else {
                // Se o nó é um filho esquerdo ou direito
                if (pai.getEsq() == atual) {
                    pai.setEsq(null) ;
                }else {
                    pai.setDir(null);
                }
            }
            System.out.println("No com o valor " + valor + " Removido com sucesso");
        }else {
            System.out.println("No com o valor " +  valor + " não é um no folha");
        }

    }

    public void remNoRaiz() {
        if (this.raiz == null) {
            System.out.println("A arvore está vazia");
        }
         // Se a raiz é uma folha
        if (this.raiz.getEsq() == null && this.raiz.getDir() == null ) {
            this.raiz = null;

        }
        // Se a raiz tem apenas um filho
        else if (this.raiz.getEsq() == null) {
            this.raiz = this.raiz.getDir();
        } else if (this.raiz.getDir() == null) {
            this.raiz = this.raiz.getEsq();

        }
        // Se a raiz tem dois filhos
        else {

            No sucessor = this.raiz.getDir();
            No paiSucessor = this.raiz;
        // Percorre a subárvore direita para encontrar o menor nó
            while(sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            // O sucessor assume o lugar da raiz
            this.raiz.setValor(sucessor.getValor());

            // Remove o nó sucessor da subárvore
            if(paiSucessor.getEsq() == sucessor) {
                paiSucessor.setEsq(paiSucessor.getDir());
            }else {
                paiSucessor.setDir(paiSucessor.getDir());
            }
        }

        System.out.println("Raiz removida com sucesso");
    }
    public void remUmFilho(int valor) {
        No atual = this.raiz;
        No pai = null;
        // Percorre a árvore até encontrar o nó a ser removido
        while (atual != null && atual.getValor() != valor ) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else {
                atual = atual.getDir();
            }
        }
        // Se não for encontrado
        if (atual == null) {
            System.out.println("No com valor " + valor + "não foi encontrado");
        }

        // Verifica se o no a ser removido tem apenas um filho
        if (atual.getEsq() == null && atual.getDir() != null) {
           // Se o no tem apenas um filho a direita
            if (pai == null) {
                this.raiz = atual.getDir();
            } else if (pai.getEsq() == atual) {
                pai.setEsq(atual.getDir());
            }else {
                pai.setDir(atual.getDir());
            }

        } else if (atual.getDir() == null && atual.getEsq() != null) {
           // Se o no tem apenas um filho a esquerda
            if (pai == null) {
                this.raiz = atual.getEsq();
            } else if (pai.getDir() == atual) {
                pai.setDir(atual.getEsq());
            }else {
                pai.setEsq(atual.getEsq());
            }
            System.out.println("No com o valor " + valor + " removido com sucesso");
        } else {
            System.out.println("No com valor " + valor + " não tem exatamente um filho");
        }

    }
    public void remDoisFilhos(int valor) {
        No atual = this.raiz;
        No pai = null;

        // Percorre a árvore para encontrar o no a ser removido
        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else{
                atual = atual.getDir();
            }
        }

        // Se o no não foi encontrado
        if (atual == null) {
            System.out.println("No com valor " + valor + " não encontrado");
        }

        // Verifica se o no tem dois filhos
        if (atual.getEsq() != null && atual.getDir() != null) {

            No sucessor = atual.getDir();
            No paiSucessor = atual;

            // Percorre a subárvore direita para encontrar o menor nó
            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            // Substitiu o valor do nó atual pelo sucessor
            atual.setValor(sucessor.getValor());

            // Remove o sucessor
            if (paiSucessor.getEsq() == sucessor) {
                paiSucessor.setEsq(sucessor.getDir());
            }else {
                paiSucessor.setDir(sucessor.getDir());
            }
            System.out.println("No com dois filhos removido com sucesso");
        }else {
            System.out.println("No com o valor " + valor + " não tem exatamente dois filhos");
        }
    }
}