inline fun <reified Celda> matrix2d(ancho:Int, alto:Int, noinline param:(Int) -> Celda) : Array <Array<Celda>> = Array(ancho,{ Array<Celda>(alto, param) })

class Tablero{
    val ancho = 3
    val alto = 3
    var celdas = matrix2d<Celda?>(ancho, alto){null}
    init {
        for (r in 0..ancho){
            for (c in 0..alto){
                celdas[r][c] = Celda(r,c)
            }
        }
    }

    override fun toString(): String {
        var res = ""
        for (r in 0..ancho){
            for(c in 0..alto){

            }
        }
    }
}
enum class FICHA{
    CRUZ,CIRCULO,VACIO
}
enum class ESTADOJUEGO {
    GANO_CRUZ, GANO_CIRCULO, EMPATE, EN_JUEGO
}
class Celda(val x:Int, val y:Int){
    var estado = FICHA.VACIO
    fun limpiaCelda(){
        estado = FICHA.VACIO
    }

    override fun toString(): String {
        return estado.toString()
    }
}
fun main (args: Array<String>){

}