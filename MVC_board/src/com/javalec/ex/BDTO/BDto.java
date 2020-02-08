package com.javalec.ex.BDTO;
import java.sql.Timestamp;


public class BDto{
	int BId;
	String BName;
	String BTitle;
	String BContent;
	Timestamp BDate;
	int BHit;
	int BGroup;
	int BStep;
	int BIndent;
	
	public BDto() {

	}
	
	public BDto(int BId, String BName,String BTitle,String BContent,Timestamp BDate,int BHit,int BGroup, int BStep, int BIndent) {
		this.BId = BId;
		this.BName = BName;
		this.BTitle = BTitle;
		this.BContent = BContent;
		this.BDate = BDate;
		this.BHit = BHit;
		this.BGroup = BGroup;
		this.BStep = BStep;
		this.BIndent = BIndent;
	
	}

	public int getBId() {
		return BId;
	}

	public void setBId(int bId) {
		BId = bId;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String getBTitle() {
		return BTitle;
	}

	public void setBTitle(String bTitle) {
		BTitle = bTitle;
	}

	public String getBContent() {
		return BContent;
	}

	public void setBContent(String bContent) {
		BContent = bContent;
	}

	public Timestamp getBDate() {
		return BDate;
	}

	public void setBDate(Timestamp bDate) {
		BDate = bDate;
	}

	public int getBHit() {
		return BHit;
	}

	public void setBHit(int bHit) {
		BHit = bHit;
	}

	public int getBGroup() {
		return BGroup;
	}

	public void setBGroup(int bGroup) {
		BGroup = bGroup;
	}

	public int getBStep() {
		return BStep;
	}

	public void setBStep(int bStep) {
		BStep = bStep;
	}

	public int getBIndent() {
		return BIndent;
	}

	public void setBIndent(int bIndent) {
		BIndent = bIndent;
	}

}
