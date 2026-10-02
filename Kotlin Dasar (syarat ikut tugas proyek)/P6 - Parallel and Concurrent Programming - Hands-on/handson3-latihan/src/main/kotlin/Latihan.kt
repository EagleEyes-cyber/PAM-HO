import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

const val PESAN_SELESAI = "SELESAI"

fun main() {
    // TODO 1: Buat LinkedBlockingQueue<String> untuk komunikasi antar thread
    val queue = LinkedBlockingQueue<String>()

    val producer = thread {
        for (i in 1..5) {
            val pesan = "Pesan #$i"
            
            // TODO 2: Masukkan pesan ke queue dengan queue.put(pesan)
            queue.put(pesan)
            
            println("[Producer] mengirim: $pesan")
            Thread.sleep(200)
        }
        // TODO 3: Kirim PESAN_SELESAI ke queue sebagai tanda producer sudah selesai
        queue.put(PESAN_SELESAI)
    }

    val consumer = thread {
        while (true) {
            // TODO 4: Ambil pesan dari queue dengan queue.take() 
            val pesan = queue.take()

            // TODO 5: Jika pesan == PESAN_SELESAI, hentikan loop (break)
            if (pesan == PESAN_SELESAI) {
                break
            }
            
            // TODO 6: Jika bukan, cetak: println("[Consumer] menerima: $pesan")
            println("[Consumer] menerima: $pesan")
        }
    }

    producer.join()
    consumer.join()
    println("Selesai!")
}
