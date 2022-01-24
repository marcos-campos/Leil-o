package com.example.leilaokotlin.model

import org.junit.Test

import org.junit.Assert.*

class LeilaoTest {

    private val leilao = Leilao("console")
    private val alex = Usuario("Alex")

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
        leilao.propoe(Lance(alex, 1000.00))
        leilao.propoe(Lance(Usuario("Bruno"), 2000.00))

        // executar ação esperada
        val maiorLanceDevolvido = leilao.getMaiorLance()

        // testar resultado esperado
        assertEquals(2000.00, maiorLanceDevolvido, 0.001)

    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){

        // criar cenário de teste
        leilao.propoe(Lance(alex, 10000.00))
        leilao.propoe(Lance(Usuario("Bruno"), 8000.00))

        // executar ação esperada
        val maiorLanceDevolvido = leilao.getMaiorLance()

        // testar resultado esperado
        assertEquals(10000.00, maiorLanceDevolvido, 0.001)

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
    fun deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){

        // criar cenário de teste
        leilao.propoe(Lance(alex, 10000.00))
        leilao.propoe(Lance(Usuario("Bruno"), 8000.00))

        // executar ação esperada
        val menorLanceDevolvido = leilao.getMenorLances()

        // testar resultado esperado
        assertEquals(8000.00, menorLanceDevolvido, 0.001)

    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances() {

        leilao.propoe(Lance(alex, 400.00))
        leilao.propoe(Lance(Usuario("Bruno"), 100.00))
        leilao.propoe(Lance(Usuario("Breno"), 500.00))


        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        tresMaioresLancesDevolvidos?.get(0)?.let { assertEquals(500.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(1)?.let { assertEquals(400.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(2)?.let { assertEquals(100.00, it.getValue(), 0.001) }

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
        leilao.propoe(Lance(Usuario("Caio"), 200.00))
        leilao.propoe(Lance(Usuario("Lucas"), 300.00))

        val tresMaioresLancesDevolvidos: List<Lance>? = leilao.tresMaioresLances()

        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        tresMaioresLancesDevolvidos?.get(0)?.let { assertEquals(500.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(1)?.let { assertEquals(400.00, it.getValue(), 0.001) }
        tresMaioresLancesDevolvidos?.get(2)?.let { assertEquals(300.00, it.getValue(), 0.001) }

    }


}