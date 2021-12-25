package com.orbanszlrd.geo.poi;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PointOfInterestRepository extends CassandraRepository<PointOfInterest, UUID> {
}
