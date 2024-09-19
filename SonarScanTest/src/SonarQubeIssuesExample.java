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


        // Issue: "finalize" should not set fields to "null"
        protected void finalize() {
            int someField = 10;
            someField = 0; // Should not be set to null
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

        // Issue: "==" and "!=" should not be used when "equals" is ov
        public void compareStrings(String str1, String str2) {
            if (str1 == str2) { // Should use equals() instead
                System.out.println("Strings are the same reference.");
            }
            if (str1 != str2) { // Should use equals() instead
                System.out.println("Strings are different references.");
            }
        }

        // Issue: "=+" should not be used instead of "+="
        public void incorrectAssignment() {
            int x = 10;
            x =+ 5; // Incorrect usage
        }

        // Issue: "toArray" should be passed an array of the proper type
        public void toArrayExample() {
            java.util.List<String> list = new java.util.ArrayList<>();
            list.add("Example");
            String[] array = list.toArray(new String[0]); // Using a proper type
        }

        // Issue: "toString()" and "clone()" methods should not return null
        public String toString() {
            return null; // Should not return null
        }

        public Object clone() {
            return null; // Should not return null
        }

        // Issue: Classes should not be compared by name
        public void compareClasses() {
            if (SonarQubeIssuesExample.class.getName().equals("SonarQubeIssuesExample")) {
                System.out.println("Comparing class names directly.");
            }
        }

        // Issue: Double Brace Initialization should not be used
        public void doubleBraceInitialization() {
            java.util.List<String> list = new java.util.ArrayList<String>() {{
                add("Item 1");
                add("Item 2");
            }}; // Double brace initialization
        }

        // Issue: Exceptions should not be created without being thrown
        public void createException() {
            Exception e = new Exception("This exception is created but not thrown."); // Not thrown
        }

        // Issue: Getters and setters should be synchronized in pairs
        private int field;
        public synchronized int getField() {
            return field;
        }
        // Missing synchronized setter for the field
        public void setField(int field) {
            this.field = field;
        }

        // Issue: Getters and setters should access the expected fields
        public int getFieldWrong() {
            return 0; // Should access 'field'
        }

        // Issue: Regular expressions should be syntactically valid
        public void invalidRegex() {
            String regex = "[a-z"; // Invalid regex
        }

        // Issue: Variables should not be self-assigned
        public void selfAssignment() {
            int x = 5;
            x = x; // Self-assignment
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
            example.incorrectAssignment();
            example.toArrayExample();
            System.out.println(example.toString());
            System.out.println(example.clone());
            example.compareClasses();
            example.doubleBraceInitialization();
            example.createException();
            example.getField();
            example.setField(10);
            example.invalidRegex();
            example.selfAssignment();
        }
}
