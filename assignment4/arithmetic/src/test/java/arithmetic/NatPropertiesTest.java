package arithmetic;

import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assume.assumeTrue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class NatPropertiesTest {
    // a == a
    @Property
    public void numberEqualsSelf(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        assertEquals(a, a);
    }

    // TODO: write your properties below
    // Put a comment before them explaining what sort of property you're testing

    // a + 0 = a
    @Property
    public void numberPlusOneEqualsSelf(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(a.add(new Zero()), a);
    }

    // 0 + a = a
    @Property
    public void zeroPlusNumberEqualsNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(a, new Zero().add(a));
    }

    // a - 0 = a
    @Property
    public void numberMinusZeroEqualsNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(a.subtract(new Zero()), a);
    }

    // a + 1 - 1 = a
    @Property
    public void numberPlusOneMinusOneEqualsNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(a.add(new Succ(new Zero())).subtract(new Succ(new Zero())), a);
    }

    // a + b = b + a
    @Property
    public void numberPlusNumberCommutative(@From(NatGenerator.class) @Size(max = 5) final Nat a, @From(NatGenerator.class) @Size(max = 5) final Nat b){
        assertEquals(a.add(b), b.add(a));
    }

    // a * 0 = 0
    @Property
    public void numberTimesZeroEqualsZero(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(a.multiply(new Zero()), new Zero());
    }

    // 0 * a = 0
    @Property
    public void zeroTimesNumberEqualsZero(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertEquals(new Zero().multiply(a), new Zero());
    }

    // 0 < 1
    @Property
    public void zeroLessThanOne(){
        assertTrue(new Zero().lessThan(new Succ(new Zero())));
    }

    // 0 < 1 + a
    @Property
    public void zeroLessThanZeroPlusNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertTrue(new Zero().lessThan(new Succ(new Zero()).add(a)));
    }

    // a < a + 1
    @Property
    public void numberLessThanNumberPlusOne(@From(NatGenerator.class) @Size(max = 10) final Nat a){
        assertTrue(a.lessThan(a.add(new Succ(new Zero()))));
    }


    // a + b !< a
    @Property
    public void numberLessThan(@From(NatGenerator.class) @Size(max = 10) final Nat a, @From(NatGenerator.class) @Size(max = 10) final Nat b) {
        assertFalse(a.add(b).lessThan(a));
    }



}
