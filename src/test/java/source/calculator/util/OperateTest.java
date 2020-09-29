package source.calculator.util;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

@EnableRuleMigrationSupport
class OperateTest {
    private StackInterface stackInterface;
    private Operate operate;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        stackInterface = new StackLIFO();
        operate = new Operate("", stackInterface);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addition() {

    }

    @Test
    void subtraction() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void division() {
    }


}