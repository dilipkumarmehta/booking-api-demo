package com.booking.beans;

public class Password {

	private String existingPassword;
	private String newPassword;
	private String repetPassword;
	private long mobileNmber;

	public String getExistingPassword() {
		return existingPassword;
	}

	public void setExistingPassword(String existingPassword) {
		this.existingPassword = existingPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepetPassword() {
		return repetPassword;
	}

	public void setRepetPassword(String repetPassword) {
		this.repetPassword = repetPassword;
	}

	public long getMobileNmber() {
		return mobileNmber;
	}

	public void setMobileNmber(long mobileNmber) {
		this.mobileNmber = mobileNmber;
	}

	@Override
	public String toString() {
		return "Password [existingPassword=" + existingPassword + ", newPassword=" + newPassword + ", repetPassword="
				+ repetPassword + ", mobileNmber=" + mobileNmber + "]";
	}

}
