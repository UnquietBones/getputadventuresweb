package getputadventuresweb.worldrules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "WORLD_RULES")
public class WorldRulesEntity {

    @Id
    @Column(name = "rule_id")
    private Integer rule_id;

    @Column(name = "rule_text")
    private String rule_text;

    @Column(name = "rule_value")
    private String rule_value;

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public String getRule_text() {
        return rule_text;
    }

    public void setRule_text(String rule_text) {
        this.rule_text = rule_text;
    }

    public String getRule_value() {
        return rule_value;
    }

    public void setRule_value(String rule_value) {
        this.rule_value = rule_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldRulesEntity that = (WorldRulesEntity) o;
        return Objects.equals(rule_id, that.rule_id) &&
                Objects.equals(rule_text, that.rule_text) &&
                Objects.equals(rule_value, that.rule_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule_id, rule_text, rule_value);
    }

    @Override
    public String toString() {
        return "WorldRulesEntity{" +
                "rule_id=" + rule_id +
                ", rule_text='" + rule_text + '\'' +
                ", rule_value='" + rule_value + '\'' +
                '}';
    }
}
