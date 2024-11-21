package ma.graphql.test.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = {Compte.class})
public interface CompteProjection1 {
    double getSolde();
}
