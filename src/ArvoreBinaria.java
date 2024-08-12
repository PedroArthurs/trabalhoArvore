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

        while(atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else {
                atual = atual.getDir();
            }
        }

        if (atual == null ) {
            System.out.println("O nó com o valor " + valor + " não existe");
            return;
        }

        if(atual.getEsq() == null && atual.getDir() == null) {

            if(atual == this.raiz) {
                this.raiz = null;
            }else {

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

        if (this.raiz.getEsq() == null && this.raiz.getDir() == null ) {
            this.raiz = null;

        }

        else if (this.raiz.getEsq() == null) {
            this.raiz = this.raiz.getDir();
        } else if (this.raiz.getDir() == null) {
            this.raiz = this.raiz.getEsq();

        }
        else {

            No sucessor = this.raiz.getDir();
            No paiSucessor = this.raiz;

            while(sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            this.raiz.setValor(sucessor.getValor());

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

        while (atual != null && atual.getValor() != valor ) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else {
                atual = atual.getDir();
            }
        }

        if (atual == null) {
            System.out.println("No com valor " + valor + "não foi encontrado");
        }

        if (atual.getEsq() == null && atual.getDir() != null) {

            if (pai == null) {
                this.raiz = atual.getDir();
            } else if (pai.getEsq() == atual) {
                pai.setEsq(atual.getDir());
            }else {
                pai.setDir(atual.getDir());
            }

        } else if (atual.getDir() == null && atual.getEsq() != null) {

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

        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            }else{
                atual = atual.getDir();
            }
        }

        if (atual == null) {
            System.out.println("No com valor " + valor + " não encontrado");
        }

        if (atual.getEsq() != null && atual.getDir() != null) {

            No sucessor = atual.getDir();
            No paiSucessor = atual;

            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            atual.setValor(sucessor.getValor());

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