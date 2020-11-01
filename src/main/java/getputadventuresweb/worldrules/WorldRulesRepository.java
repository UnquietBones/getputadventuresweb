package getputadventuresweb.worldrules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldRulesRepository extends JpaRepository<WorldRulesEntity, Integer> {
}