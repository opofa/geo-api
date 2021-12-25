package com.orbanszlrd.geo.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(value = "country")
public class Country {
    @Id
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 2, max = 100)
    @CassandraType(type= CassandraType.Name.TEXT)
    private String name;

    @Size(min = 2, max = 2)
    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String alpha2Code;

    @Size(min = 3, max = 3)
    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String alpha3Code;

    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String capital;

    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String subregion;

    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String region;

    @CassandraType(type= CassandraType.Name.BIGINT)
    private Long population;

    @CassandraType(type= CassandraType.Name.FLOAT)
    private Float area;

    @CassandraType(type= CassandraType.Name.VARCHAR)
    private String flag;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
