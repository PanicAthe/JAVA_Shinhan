package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
public class Bag<M, S, C> {
	M model;
	S size;
	C color;

}
