class ReflectionExampleWithReturnType  {
    public String reflectionPerfection(String parameter){
        System.out.println("Called an instance method which returns a value and takes a parameter returning string 'One Parameter'");
        return "One Parameter";
    }
    public static String reflectionPerfection(){
        System.out.println("Called a static method which returns a vlaue and takes no parameters");
        return "One Parameter";
    }
}