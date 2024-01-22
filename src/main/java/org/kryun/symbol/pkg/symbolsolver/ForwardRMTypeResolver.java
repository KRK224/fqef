package org.kryun.symbol.pkg.symbolsolver;

import java.util.Optional;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import org.kryun.symbol.pkg.symbolsolver.interfaces.generateresolvedtype.GenerateClassResolvedType;
import org.kryun.symbol.pkg.symbolsolver.interfaces.referabletyperesolver.AbstractClassReferableTypeResolver;

public class ForwardRMTypeResolver implements GenerateClassResolvedType<MethodDeclaration> {
    private static class LazyHolder {
        private static final ForwardRMTypeResolver INSTANCE = new ForwardRMTypeResolver();
    }

    public static ForwardRMTypeResolver getInstance() {
        return LazyHolder.INSTANCE;
    }

    private AbstractClassReferableTypeResolver rmTypeResolverImpl;

    private ForwardRMTypeResolver() {
        this.rmTypeResolverImpl = new AbstractClassReferableTypeResolver();
    }

    @Override
    public final ResolvedType generateResolvedType(MethodDeclaration md) throws Exception {
        try {
            return md.resolve().getReturnType();
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<String> getFullQualifiedName(MethodDeclaration md) {
        try {
            return rmTypeResolverImpl.getFullQualifiedName(generateResolvedType(md));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
