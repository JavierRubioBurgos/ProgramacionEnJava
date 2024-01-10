import java.util.Random;

public class Pedido {
    private int numeroPedido;
    private Random random;

    public Pedido() {
        random = new Random();
        numeroPedido = generarNumeroPedido();
    }

    private int generarNumeroPedido() {
        return random.nextInt(10000000);
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
}