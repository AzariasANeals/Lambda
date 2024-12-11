
/**
 * This is the MathOperation interface. Uses FunctionalInterface.
 */
@FunctionalInterface
public interface MathOperation
{
    // This allows for a method reference so any method that is passed in can be used as
    // long as it meets the requirements of this functional interface.
    int operate(int a, int b);
    
}
