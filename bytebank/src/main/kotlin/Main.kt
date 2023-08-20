fun main() {
    println("Bem-Vindo ao ByteBank")

    val contaRebeka = Conta(titular = "Rebeka", numero = 1000)
    contaRebeka.deposita(200.0)

    val contaJeremias = Conta(numero = 1001, titular = "Jeremias",)
    contaJeremias.deposita(300.0)

    println(contaJeremias.titular)
    println(contaJeremias.numero)
    println(contaJeremias.saldo)

    println(contaRebeka.titular)
    println(contaRebeka.numero)
    println(contaRebeka.saldo)

    println("Depositando na conta da Rebeka")
    contaRebeka.deposita(50.0)
    println(contaRebeka.saldo)

    println("Depositando na conta do Jeremias")
    contaJeremias.deposita(70.0)
    println(contaJeremias.saldo)

    println("Sacando na conta da Rebeka")
    contaRebeka.saca(250.0)
    println(contaRebeka.saldo)

    println("Sacando na conta do Jeremias")
    contaJeremias.saca(100.0)
    println(contaJeremias.saldo)

    println("Saque em excesso na conta da Rebeka")
    contaRebeka.saca(100.0)
    println(contaRebeka.saldo)

    println("Saque em excesso na conta do Jeremais")
    contaJeremias.saca(500.0)
    println(contaJeremias.saldo)

    println("Transferência da conta do Jeremias para conta da Rebeka")

    if (contaJeremias.tranfere(destino = contaRebeka, valor = 300.0)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println(contaRebeka.saldo)
    println(contaJeremias.saldo)
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor
        }
    }

    fun tranfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }


    fun testaCopiaseReferencias() {
        val numeroX = 10
        var numeroY = numeroX
        numeroY++

        println("numeroX $numeroX")
        println("numeroy $numeroY")

        val contaLucas = Conta(  "Lucas",  1002)
        contaLucas.titular = "Lucas"
        var contaAna = Conta( "Ana",  1003)
        contaAna.titular = "Ana"
        contaLucas.titular = "Lucas"

        println("titular conta lucas: ${contaLucas.titular}")
        println("titular conta ana: ${contaAna.titular}")

        println(contaLucas)
        println(contaAna)
    }

    fun testaLacos() {
        var i = 0
        while (i < 5) {
            val titular: String = "Rebeka $i"
            val numeroConta: Int = 1000 + i
            var saldo = i + 10.0

            println("Titular: $titular")
            println("Número da Conta: $numeroConta")
            println("Saldo da Conta $saldo")
            println()
            i++
        }

        for (i in 5 downTo 1) {
            val titular: String = "Rebeka $i"
            val numeroConta: Int = 1000 + i
            var saldo = i + 10.0

            println("Titular: $titular")
            println("Número da Conta: $numeroConta")
            println("Saldo: $saldo")
            println()
        }
    }

    fun testaCondicoes(saldo: Double) {
        if (saldo > 0.0) {
            println("A Conta é positiva")
        } else if (saldo == 0.0) {
            println("Conta é neutra")

        } else {
            println("Conta é negativa")
        }

        when {
            saldo > 0.0 -> println("A Conta é positiva")
            saldo == 0.0 -> println("Conta é neutra")
            else -> println("Conta é negativa")
        }
    }
}