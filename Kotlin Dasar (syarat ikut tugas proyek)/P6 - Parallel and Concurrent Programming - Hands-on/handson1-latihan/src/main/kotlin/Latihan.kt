import kotlin.concurrent.thread

class Counter {
    private var c = 0
    fun increment() {
        // TODO 1
        synchronized(this) {
            c++
        }
    }
    fun value(): Int {
        // TODO 2
        return c
    }
}

fun main() {
    val counter = Counter()
    val iterasi = 100_000

    val t1 = thread {
        repeat(iterasi) { counter.increment() }
    }
    val t2 = thread {
        repeat(iterasi) { counter.increment() }
    }

    t1.join()
    t2.join()

    println("Hasil akhir: ${counter.value()} (seharusnya ${iterasi * 2})")
}
