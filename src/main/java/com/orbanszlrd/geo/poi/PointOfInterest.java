package com.orbanszlrd.geo.poi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "poi")
public class PointOfInterest {
    @Id
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 2, max = 255)
    @CassandraType(type = CassandraType.Name.VARCHAR)
    private String name;

    @NotBlank
    @Size(min = 2, max = 255)
    @CassandraType(type = CassandraType.Name.VARCHAR)
    private String type;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column("country_name")
    @CassandraType(type = CassandraType.Name.VARCHAR)
    private String countryName;

    @CassandraType(type = CassandraType.Name.FLOAT)
    private Float latitude;

    @CassandraType(type = CassandraType.Name.FLOAT)
    private Float longitude;

    @CassandraType(type = CassandraType.Name.FLOAT)
    private Float altitude;

    public PointOfInterest(UUID id, String name, String countryName) {
        this.id = id;
        this.name = name;
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return name.equals(that.name) && countryName.equals(that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryName);
    }

    @Override
    public String toString() {
        return name + "(" + countryName + ")";
    }
}
