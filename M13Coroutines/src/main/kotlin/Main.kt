import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch{
        delay(2000)
        println("world !")
    }

    launch{
        for(i in 1..500){
            delay(10)
            if(i % 130 == 0)
                println(".")
            else
                println(".")
        }
    }
    println("Hello World!")
}