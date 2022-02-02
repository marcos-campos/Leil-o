package com.example.leilaokotlin.model

import org.junit.Test

import org.junit.Assert.*

class LeilaoTest {

    private val leilao = Leilao("console")
    private val alex = Usuario("Alex")
    private val lucas = Usuario("Lucas")

    //como nomear um teste: [nome do método] [estado de teste] [resultado esperado]
    @Test
    fun getDescription_QuandoRecebeDescricao_DevolveDescricao() {
        
        // criar cenário de teste
        leilao

        // executar ação esperada
        val descricaoDevolvida = leilao.getDescription()

        // testar resultado esperado
        assertEquals("console", descricaoDevolvida)

    }

    //como nomear um teste: [deve] [resultado esperado] [estado de teste]

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebemosApenasUmLance(){

        // criar cenário de teste
        leilao.propoe(Lance(alex, 200.00))

        // executar ação esperada
        val maiorLanceDevolvido = leilao.getMaiorLance()

        // testar resultado esperado
        assertEquals(200.00, maiorLanceDevolvido, 0.001)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){

        // criar cenário de teste
        leilao.propoe(Lance(Usuario("Jose"), 2000.00))
        leilao.propoe(Lance(Usuario("Josias"), 3000.00))
        leilao.propoe(Lance(Usuario("testes"), 5000.00))

        // executar ação esperada
        val maiorLanceDevolvido = leilao.getMaiorLance()

        // testar resultado esperado
        assertEquals(5000.00, maiorLanceDevolvido, 0.001)

    }

    @Test
    fun deve_DevolverMenorLance_QuandoRecebeApenasUmLance() {

        // criar cenário de teste
        leilao.propoe(Lance(alex, 1000.00))

        // executar ação esperada
        val deveRetornarMenorLance = leilao.getMenorLances()

        // testar resultado esperado
        assertEquals(1000.00, deveRetornarMenorLance, 0.0001)
    }

    @Test
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){

        // criar cenário de teste
        leilao.propoe(Lance(alex, 1000.00))
        leilao.propoe(Lance(Usuario("Bruno"), 2000.00))

        // executar ação esperada
        val menorLanceDevolvido = leilao.getMenorLances()

        // testar resultado esperado
        assertEquals(1000.00, menorLanceDevolvido, 0.001)

    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances() {

        leilao.propoe(Lance(alex, 400.00))
        leilao.propoe(Lance(Usuario("Bruno"), 500.00))
        leilao.propoe(Lance(Usuario("Breno"), 600.00))


        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        tresMaioresLancesDevolvidos?.get(0)?.let { assertEquals(600.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(1)?.let { assertEquals(500.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(2)?.let { assertEquals(400.00, it.getValue(), 0.001) }

    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoNaoRecebeLances() {

        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(0, tresMaioresLancesDevolvidos?.size)

    }

    @Test
    fun deve_DevolverTresMaoiresLances_QuandoRecebeApenasUmLance() {

        leilao.propoe(Lance(alex, 200.00))

        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(1, tresMaioresLancesDevolvidos?.size)
        tresMaioresLancesDevolvidos?.get(0)?.getValue()?.let { assertEquals(200.00, it, 0.00) }

    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances() {

        leilao.propoe(Lance(alex, 100.00))
        leilao.propoe(Lance(Usuario("Bruno"), 200.00))

        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(2, tresMaioresLancesDevolvidos?.size)
        assertEquals(200.00, tresMaioresLancesDevolvidos?.get(0)?.getValue())
        assertEquals(100.00, tresMaioresLancesDevolvidos?.get(1)?.getValue())

    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeCincoLances() {

        leilao.propoe(Lance(alex, 400.00))
        leilao.propoe(Lance(Usuario("Bruno"), 100.00))
        leilao.propoe(Lance(Usuario("Breno"), 500.00))
        leilao.propoe(Lance(Usuario("Caio"), 700.00))
        leilao.propoe(Lance(Usuario("Lucas"), 800.00))

        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        tresMaioresLancesDevolvidos?.get(0)?.let { assertEquals(800.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(1)?.let { assertEquals(700.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(2)?.let { assertEquals(500.00, it.getValue(), 0.001) }

    }

    @Test
    fun deve_DevolverValorZeroParaMaiorLance_QuuandoNaoTiverLances(){

        val maiorLanceDevolvido  = leilao.getMaiorLance()

        assertEquals(0.0, maiorLanceDevolvido, 0.00)

    }

    @Test
    fun deve_DevolverValorZeroParaMenorLance_QuandoNaoTiverLances(){

        val menorLanceDevolvido = leilao.getMenorLances()

        assertEquals(0.0, menorLanceDevolvido, 0.00)
    }

    @Test
    fun naoDeve_AdicionarLance_QuandoLanceMenorQueOMaiorLance() {
        leilao.propoe(Lance(alex, 500.00))
        leilao.propoe(Lance(Usuario("Bruno"), 400.00))

        val quantidadeLancesDevolvidos =  leilao.quantidadeLancesDevolvido()

        assertEquals(1, quantidadeLancesDevolvidos)
    }

    @Test
    fun naoDeve_AdicionarLance_QuandoForMesmoUsuarioDoUltimoLance() {
        leilao.propoe(Lance(alex, 500.00))
        leilao.propoe(Lance(alex, 600.00))

        val quantidadeLancesDevolvidos =  leilao.quantidadeLancesDevolvido()

        assertEquals(1, quantidadeLancesDevolvidos)

    }

    @Test
    fun naoDeve_AdicionarLance_QuandoReceberMaisDeCincoLancesDoMesmoUsuario() {
        val lucas = Usuario("Lucas")
        leilao.propoe(Lance(alex, 100.00))
        leilao.propoe(Lance(lucas, 200.00))
        leilao.propoe(Lance(alex, 300.00))
        leilao.propoe(Lance(lucas, 400.00))
        leilao.propoe(Lance(alex, 500.00))
        leilao.propoe(Lance(lucas, 600.00))
        leilao.propoe(Lance(alex, 700.00))
        leilao.propoe(Lance(lucas, 800.00))
        leilao.propoe(Lance(alex, 900.00))
        leilao.propoe(Lance(lucas, 1000.00))
        leilao.propoe(Lance(alex, 1100.00))
        leilao.propoe(Lance(lucas, 1200.00))

        val quantidadeLancesDevolvidos =  leilao.quantidadeLancesDevolvido()

        assertEquals(10, quantidadeLancesDevolvidos)

    }

}