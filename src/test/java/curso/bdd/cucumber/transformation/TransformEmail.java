package curso.bdd.cucumber.transformation;

import java.util.Locale;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;

public class TransformEmail implements TypeRegistryConfigurer {
	private TypeRegistry typeRegistry;

	@Override
	public Locale locale() {
		// TODO Auto-generated method stub
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "email",
                ".*?",
                String.class,
                new CaptureGroupTransformer<String>() {
                    @Override
                    public String transform(String[] args) {
                        //return RandomStringUtils.random(Integer.parseInt(args[0]), Boolean.valueOf(args[1]), Boolean.valueOf(args[2]));
                    	String argumento = (String) args[0];
                    	return argumento + "@com.mx";
                    }
                })
        );
		this.typeRegistry = typeRegistry;
		
	}
	
	public TypeRegistry getTypeRegistry() {
		return this.typeRegistry;
	}
}
