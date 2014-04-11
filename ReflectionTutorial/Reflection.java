import java.lang.reflect.Method;

class main {
	public static void main (String[] args) {

		ReflectionExampleNoReturnType noReturnType = new ReflectionExampleNoReturnType();
		ReflectionExampleWithReturnType returnType = new ReflectionExampleWithReturnType();

		String methodName = "reflectionPerfection";
		
		try {
			System.out.println("<<    One");
			Method method = noReturnType.getClass().getMethod(methodName);
			method.invoke(noReturnType);

			System.out.println(" ");
			System.out.println("<<    Two");

			method = noReturnType.getClass().getMethod(methodName, String.class);
			method.invoke(noReturnType, "Parameter Value");

			System.out.println(" ");
			System.out.println("<<    Three");

			method = returnType.getClass().getMethod(methodName, String.class);
			returned = (String) method.invoke(returnType, "Parameter Value");
			System.out.println("Returned value: '" + returned + "'");
			
			System.out.println(" ");
			System.out.println("<<    Four");
			
			method = returnType.getClass().getMethod(methodName);
			String returned = (String) method.invoke(returnType);
			System.out.println("Returned value: '" + returned + "'");
			

		} catch (NoSuchMethodException e) {
			System.out.println("Reflection says no");
		} catch (Exception e) {

		}
	}
}