import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun hitungKuadrat(n: Int): Int {
    Thread.sleep(1000) // Simulasi kerja berat
    return n * n
}

fun main() {
    val angka = listOf(1, 2, 3, 4)
    val startTime = System.currentTimeMillis()

    // TODO 1
    val executor = Executors.newFixedThreadPool(4)

    // TODO 2
    val futures = angka.map { n -> executor.submit(Callable { hitungKuadrat(n) }) }

    // TODO 3
    val hasil = futures.map { it.get() }
    println("Hasil: $hasil")

    // TODO 4
    executor.shutdown()

    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")
}
