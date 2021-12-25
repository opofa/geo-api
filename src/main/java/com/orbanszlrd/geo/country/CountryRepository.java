package com.orbanszlrd.geo.country;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends CassandraRepository<Country, UUID> {
}
