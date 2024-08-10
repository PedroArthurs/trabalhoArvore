public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(40);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(31);

        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        arvoreBinaria.remDoisFilhos(3);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
    }
}