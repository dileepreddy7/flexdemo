import org.springframework.web.bind.annotation.RequestMapping;

public class SonarQubeIssuesExample {

    // Issue: "@Override" should be used on overriding and implementing methods
    public void someMethod() {
        System.out.println("This method should have @Override if it's overriding another method.");
    }

    // Issue: "@RequestMapping" methods should not be "private"
    @RequestMapping
    private void handleRequest() {
        System.out.println("This request handler should not be private.");
    }

    // Issue: "close()" calls should not be redundant
    public void redundantClose() {
        java.io.Closeable resource = null;
        if (resource != null) {
            resource.close();
            resource.close(); // Redundant close
        }
    }

    // Issue: "compareTo" should not be overloaded
    public int compareTo(String other) {
        return 0;
    }

    // Issue: "equals" method overrides should accept "Object" parameters
    public boolean equals(String obj) {
        return false;
    }

    // Issue: "equals" method parameters should not be marked "@Nonnull"
    public boolean equals(@javax.annotation.Nonnull String obj) {
        return false;
    }

    // Issue: "finalize" should not set fields to "null"
    protected void finalize() {
        // Finalization should not set fields to null
        int someField = 10;
        someField = 0; // Should be null or equivalent
    }

    // Issue: "getClass" should not be used for synchronization
    public void synchronizeMethod() {
        synchronized (getClass()) {
            System.out.println("This synchronization should not use getClass()");
        }
    }

    // Issue: "if ... else if" constructs should end with "else" clauses
    public void conditionalMethod(int x) {
        if (x < 0) {
            System.out.println("Negative");
        } else if (x > 0) {
            System.out.println("Positive");
        }
        // Missing else clause
    }

    // Issue: "NullPointerException" should not be caught
    public void catchNullPointer() {
        try {
            String str = null;
            str.length(); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException, which should be avoided.");
        }
    }

    // Issue: "==" and "!=" should not be used when "equals" is overridden
    public void compareStrings(String str1, String str2) {
        if (str1 == str2) { // Should use equals() instead
            System.out.println("Strings are the same reference.");
        }
        if (str1 != str2) { // Should use equals() instead
            System.out.println("Strings are different references.");
        }
    }

    public static void main(String[] args) {
        SonarQubeIssuesExample example = new SonarQubeIssuesExample();

        // Demonstrating the methods
        example.someMethod();
        example.handleRequest(); // This won't work in a real Spring application since it's private
        example.redundantClose();
        example.compareTo("test");
        example.equals("test");
        example.equals(null); // Avoiding null for testing here
        example.synchronizeMethod();
        example.conditionalMethod(1);
        example.catchNullPointer();
        example.compareStrings("hello", "world");
    }
}
