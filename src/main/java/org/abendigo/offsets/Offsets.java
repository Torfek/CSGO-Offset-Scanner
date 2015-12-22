package org.abendigo.offsets;

import org.abendigo.process.Module;

import static org.abendigo.misc.PatternScanner.*;

/**
 * Created by Jonathan on 11/13/2015.
 */
public final class Offsets {

	/**
	 * Client.dll offsets
	 */
	public static int m_dwRadarBase;
	public static int m_dwWeaponTable;
	public static int m_dwWeaponTableIndex;
	public static int m_dwInput;
	public static int m_dwGlowObject;
	public static int m_dwForceJump;
	public static int m_dwForceAttack;
	public static int m_dwGlobalVars;
	public static int m_dwViewMatrix;
	public static int m_dwEntityList;
	public static int m_dwLocalPlayer;

	/**
	 * Engine.dll offsets
	 */
	public static int m_dwClientState;
	public static int m_dwInGame;
	public static int m_dwMaxPlayer;
	public static int m_dwMapDirectory;
	public static int m_dwMapname;
	public static int m_dwPlayerInfo;
	public static int m_dwViewAngles;
	public static int m_dwEnginePosition;

	public static void load(Module client, Module engine) {
		/**
		 * Client.dll offsets
		 */
		m_dwRadarBase = getAddressForPattern(client, 0x1, 0x0, READ | SUBTRACT, 0xA1, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x0C, 0xB0, 0x8B, 0x01, 0xFF, 0x50, 0x00, 0x46, 0x3B, 0x35, 0x00, 0x00, 0x00, 0x00, 0x7C, 0xEA, 0x8B, 0x0D, 0x00, 0x00, 0x00, 0x00);
		m_dwWeaponTable = getAddressForPattern(client, 0x1, 0x0, READ | SUBTRACT, 0xA1, 0x00, 0x00, 0x00, 0x00, 0x0F, 0xB7, 0xC9, 0x03, 0xC9, 0x8B, 0x44, 0x00, 0x0C, 0xC3);
		m_dwWeaponTableIndex = getAddressForPattern(client, 0x3, 0x0, READ, 0x66, 0x8B, 0x8E, 0x00, 0x00, 0x00, 0x00, 0xE8, 0x00, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x00, 0x50);
		m_dwInput = getAddressForPattern(client, 0x1, 0x0, READ | SUBTRACT, 0xB9, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x75, 0x08, 0xE8, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x06);
		m_dwGlowObject = getAddressForPattern(client, 0x1, 0x4, READ | SUBTRACT, 0xA1, 0x00, 0x00, 0x00, 0x00, 0xa8, 0x01, 0x75, 0x00, 0x0f, 0x57, 0xc0, 0xc7, 0x05);
		m_dwForceJump = getAddressForPattern(client, 0x2, 0x0, READ | SUBTRACT, 0x89, 0x15, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x15, 0x00, 0x00, 0x00, 0x00, 0xF6, 0xC2, 0x03, 0x74, 0x03, 0x83, 0xCE, 0x08);
		m_dwForceAttack = getAddressForPattern(client, 0x2, 0x0, READ | SUBTRACT, 0x89, 0x15, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x15, 0x00, 0x00, 0x00, 0x00, 0xF6, 0xC2, 0x03, 0x74, 0x03, 0x83, 0xCE, 0x04);
		m_dwViewMatrix = getAddressForPattern(client, 0x33C, 0xB0, READ | SUBTRACT, 0x81, 0xC6, 0x00, 0x00, 0x00, 0x00, 0x88, 0x45, 0x92, 0x0F, 0xB6, 0xC0);
		m_dwEntityList = getAddressForPattern(client, 0x1, 0x0, READ | SUBTRACT, 0xBB, 0x00, 0x00, 0x00, 0x00, 0x83, 0xFF, 0x01, 0x0F, 0x8C, 0x00, 0x00, 0x00, 0x00, 0x3B, 0xF8);
		m_dwLocalPlayer = getAddressForPattern(client, 0x1, 0x10, READ | SUBTRACT, 0xA3, 0x00, 0x00, 0x00, 0x00, 0xC7, 0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xE8, 0x00, 0x00, 0x00, 0x00, 0x59, 0xC3, 0x6A, 0x00);

		/**
		 * Engine.dll offsets
		 */
		m_dwGlobalVars = getAddressForPattern(engine, 0x12, 0x0, READ | SUBTRACT, 0x8B, 0x0D, 0x0, 0x0, 0x0, 0x0, 0x83, 0xC4, 0x04, 0x8B, 0x01, 0x68, 0x0, 0x0, 0x0, 0x0, 0xFF, 0x35);
		m_dwClientState = getAddressForPattern(engine, 0x1, 0x0, READ | SUBTRACT, 0xA1, 0x00, 0x00, 0x00, 0x00, 0xF3, 0x0F, 0x11, 0x80, 0x00, 0x00, 0x00, 0x00, 0xD9, 0x46, 0x04, 0xD9, 0x05, 0x00, 0x00, 0x00, 0x00);
		m_dwInGame = getAddressForPattern(engine, 0x2, 0x0, READ, 0x83, 0xB9, 0x00, 0x00, 0x00, 0x00, 0x06, 0x0F, 0x94, 0xC0, 0xC3);
		m_dwMaxPlayer = getAddressForPattern(engine, 0x7, 0x0, READ, 0xA1, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x80, 0x00, 0x00, 0x00, 0x00, 0xC3, 0xCC, 0xCC, 0xCC, 0xCC, 0x55, 0x8B, 0xEC, 0x8B, 0x45, 0x08);
		m_dwMapDirectory = getAddressForPattern(engine, 0x1, 0x0, READ, 0x05, 0x00, 0x00, 0x00, 0x00, 0xC3, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0x80, 0x3D);
		m_dwMapname = getAddressForPattern(engine, 0x1, 0x0, READ, 0x05, 0x00, 0x00, 0x00, 0x00, 0xC3, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0xCC, 0xA1, 0x00, 0x00, 0x00, 0x00);
		m_dwPlayerInfo = getAddressForPattern(engine, 0x2, 0x0, READ, 0x8B, 0x88, 0x00, 0x00, 0x00, 0x00, 0x8B, 0x01, 0x8B, 0x40, 0x00, 0xFF, 0xD0, 0x8B, 0xF8);
		m_dwViewAngles = getAddressForPattern(engine, 0x4, 0x0, READ, 0xF3, 0x0F, 0x11, 0x80, 0x00, 0x00, 0x00, 0x00, 0xD9, 0x46, 0x04, 0xD9, 0x05, 0x00, 0x00, 0x00, 0x00);
		m_dwEnginePosition = getAddressForPattern(engine, 0x4, 0x0, READ | SUBTRACT, 0xF3, 0x0F, 0x11, 0x15, 0x00, 0x00, 0x00, 0x00, 0xF3, 0x0F, 0x11, 0x0D, 0x00, 0x00, 0x00, 0x00, 0xF3, 0x0F, 0x11, 0x05, 0x00, 0x00, 0x00, 0x00, 0xF3, 0x0F, 0x11, 0x3D, 0x00, 0x00, 0x00, 0x00);
	}

}
