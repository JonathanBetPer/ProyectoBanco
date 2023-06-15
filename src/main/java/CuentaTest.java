import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    Cuenta cuentaTest = new Cuenta(1, 10,"test");

    @org.junit.jupiter.api.Test
    void ingresar1() {
        assertTrue(cuentaTest.ingresar(10));
    }

    @org.junit.jupiter.api.Test
    void ingresar2() {
        assertFalse(cuentaTest.ingresar(-10));
    }


    @org.junit.jupiter.api.Test
    void retirar1() {
        assertFalse(cuentaTest.retirar(-10));
    }

    @org.junit.jupiter.api.Test
    void retirar2() {
        assertFalse(cuentaTest.retirar(100000));
    }

    @org.junit.jupiter.api.Test
    void retirar3() {
        assertTrue(cuentaTest.retirar(10));
    }
}