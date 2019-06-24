package gabriel;/**
 * @author Evgeny Borisov
 */

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Qualifier
public @interface SymbolQualifier {
    SymbolType value();
}