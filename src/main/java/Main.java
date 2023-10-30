// Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
// Вилки лежат на столе между каждой парой ближайших философов.
// Каждый философ может либо есть, либо размышлять.
// Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
// Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
// Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
// Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза


public class Main {
    private static final String[] philosophers = {"Phil1", "Phil2", "Phil3", "Phil4", "Phil5"};
    public static void main(String[] args) {
        Philosopher[] ph = new Philosopher[5];
        Fork[] forks = new Fork[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork(i);

        }
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                ph[i] = new Philosopher(philosophers[i], forks[i], forks[(i+1) % 5]);
            } else {
                ph[i] = new Philosopher(philosophers[i], forks[(i+1) % 5], forks[i]);
            }

            Thread thread = new Thread(ph[i]);
            thread.start();
        }
    }
}
