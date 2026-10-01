open class Animal(val name: String)
class Cat(name: String) : Animal(name)

// TODO 1: Tambahkan modifier variance yang tepat pada T di sini
interface Container<out T> {
    fun get(): T
}

class CatContainer(private val cat: Cat) : Container<Cat> {
    override fun get(): Cat = cat
}

fun printAnimalName(container: Container<Animal>) {
    println("Nama hewan: ${container.get().name}")
}

fun main() {
    val catContainer: Container<Cat> = CatContainer(Cat("Whiskers"))
    
    // TODO 2: Setelah TODO 1 benar, baris berikut akan bisa di-compile
    printAnimalName(catContainer)
}
