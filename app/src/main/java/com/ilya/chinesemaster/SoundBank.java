package com.ilya.chinesemaster;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundBank {
    private MediaPlayer player;

    public void playRadical(Context context, int number) {
        int resId = radicalRes(number);
        if (resId == 0) return;
        play(context, resId);
    }

    public void play(Context context, int resId) {
        try {
            stop();
            player = MediaPlayer.create(context, resId);
            if (player != null) {
                player.setOnCompletionListener(mp -> stop());
                player.start();
            }
        } catch (Exception ignored) {}
    }

    public void stop() {
        try {
            if (player != null) {
                player.release();
                player = null;
            }
        } catch (Exception ignored) {}
    }

    public int radicalRes(int n) {
        switch (n) {
            case 1: return R.raw.k001;
            case 2: return R.raw.k002;
            case 3: return R.raw.k003;
            case 4: return R.raw.k004;
            case 5: return R.raw.k005;
            case 6: return R.raw.k006;
            case 7: return R.raw.k007;
            case 8: return R.raw.k008;
            case 9: return R.raw.k009;
            case 10: return R.raw.k010;
            case 11: return R.raw.k011;
            case 12: return R.raw.k012;
            case 13: return R.raw.k013;
            case 14: return R.raw.k014;
            case 15: return R.raw.k015;
            case 16: return R.raw.k016;
            case 17: return R.raw.k017;
            case 18: return R.raw.k018;
            case 19: return R.raw.k019;
            case 20: return R.raw.k020;
            case 21: return R.raw.k021;
            case 22: return R.raw.k022;
            case 23: return R.raw.k023;
            case 24: return R.raw.k024;
            case 25: return R.raw.k025;
            case 26: return R.raw.k026;
            case 27: return R.raw.k027;
            case 28: return R.raw.k028;
            case 29: return R.raw.k029;
            case 30: return R.raw.k030;
            case 31: return R.raw.k031;
            case 32: return R.raw.k032;
            case 33: return R.raw.k033;
            case 34: return R.raw.k034;
            case 35: return R.raw.k035;
            case 36: return R.raw.k036;
            case 37: return R.raw.k037;
            case 38: return R.raw.k038;
            case 39: return R.raw.k039;
            case 40: return R.raw.k040;
            case 41: return R.raw.k041;
            case 42: return R.raw.k042;
            case 43: return R.raw.k043;
            case 44: return R.raw.k044;
            case 45: return R.raw.k045;
            case 46: return R.raw.k046;
            case 47: return R.raw.k047;
            case 48: return R.raw.k048;
            case 49: return R.raw.k049;
            case 50: return R.raw.k050;
            case 51: return R.raw.k051;
            case 52: return R.raw.k052;
            case 53: return R.raw.k053;
            case 54: return R.raw.k054;
            case 55: return R.raw.k055;
            case 56: return R.raw.k056;
            case 57: return R.raw.k057;
            case 58: return R.raw.k058;
            case 59: return R.raw.k059;
            case 60: return R.raw.k060;
            case 61: return R.raw.k061;
            case 62: return R.raw.k062;
            case 63: return R.raw.k063;
            case 64: return R.raw.k064;
            case 65: return R.raw.k065;
            case 66: return R.raw.k066;
            case 67: return R.raw.k067;
            case 68: return R.raw.k068;
            case 69: return R.raw.k069;
            case 70: return R.raw.k070;
            case 71: return R.raw.k071;
            case 72: return R.raw.k072;
            case 73: return R.raw.k073;
            case 74: return R.raw.k074;
            case 75: return R.raw.k075;
            case 76: return R.raw.k076;
            case 77: return R.raw.k077;
            case 78: return R.raw.k078;
            case 79: return R.raw.k079;
            case 80: return R.raw.k080;
            case 81: return R.raw.k081;
            case 82: return R.raw.k082;
            case 83: return R.raw.k083;
            case 84: return R.raw.k084;
            case 85: return R.raw.k085;
            case 86: return R.raw.k086;
            case 87: return R.raw.k087;
            case 88: return R.raw.k088;
            case 89: return R.raw.k089;
            case 90: return R.raw.k090;
            case 91: return R.raw.k091;
            case 92: return R.raw.k092;
            case 93: return R.raw.k093;
            case 94: return R.raw.k094;
            case 95: return R.raw.k095;
            case 96: return R.raw.k096;
            case 97: return R.raw.k097;
            case 98: return R.raw.k098;
            case 99: return R.raw.k099;
            case 100: return R.raw.k100;
            case 101: return R.raw.k101;
            case 102: return R.raw.k102;
            case 103: return R.raw.k103;
            case 104: return R.raw.k104;
            case 105: return R.raw.k105;
            case 106: return R.raw.k106;
            case 107: return R.raw.k107;
            case 108: return R.raw.k108;
            case 109: return R.raw.k109;
            case 110: return R.raw.k110;
            case 111: return R.raw.k111;
            case 112: return R.raw.k112;
            case 113: return R.raw.k113;
            case 114: return R.raw.k114;
            case 115: return R.raw.k115;
            case 116: return R.raw.k116;
            case 117: return R.raw.k117;
            case 118: return R.raw.k118;
            case 119: return R.raw.k119;
            case 120: return R.raw.k120;
            case 121: return R.raw.k121;
            case 122: return R.raw.k122;
            case 123: return R.raw.k123;
            case 124: return R.raw.k124;
            case 125: return R.raw.k125;
            case 126: return R.raw.k126;
            case 127: return R.raw.k127;
            case 128: return R.raw.k128;
            case 129: return R.raw.k129;
            case 130: return R.raw.k130;
            case 131: return R.raw.k131;
            case 132: return R.raw.k132;
            case 133: return R.raw.k133;
            case 134: return R.raw.k134;
            case 135: return R.raw.k135;
            case 136: return R.raw.k136;
            case 137: return R.raw.k137;
            case 138: return R.raw.k138;
            case 139: return R.raw.k139;
            case 140: return R.raw.k140;
            case 141: return R.raw.k141;
            case 142: return R.raw.k142;
            case 143: return R.raw.k143;
            case 144: return R.raw.k144;
            case 145: return R.raw.k145;
            case 146: return R.raw.k146;
            case 147: return R.raw.k147;
            case 148: return R.raw.k148;
            case 149: return R.raw.k149;
            case 150: return R.raw.k150;
            case 151: return R.raw.k151;
            case 152: return R.raw.k152;
            case 153: return R.raw.k153;
            case 154: return R.raw.k154;
            case 155: return R.raw.k155;
            case 156: return R.raw.k156;
            case 157: return R.raw.k157;
            case 158: return R.raw.k158;
            case 159: return R.raw.k159;
            case 160: return R.raw.k160;
            case 161: return R.raw.k161;
            case 162: return R.raw.k162;
            case 163: return R.raw.k163;
            case 164: return R.raw.k164;
            case 165: return R.raw.k165;
            case 166: return R.raw.k166;
            case 167: return R.raw.k167;
            case 168: return R.raw.k168;
            case 169: return R.raw.k169;
            case 170: return R.raw.k170;
            case 171: return R.raw.k171;
            case 172: return R.raw.k172;
            case 173: return R.raw.k173;
            case 174: return R.raw.k174;
            case 175: return R.raw.k175;
            case 176: return R.raw.k176;
            case 177: return R.raw.k177;
            case 178: return R.raw.k178;
            case 179: return R.raw.k179;
            case 180: return R.raw.k180;
            case 181: return R.raw.k181;
            case 182: return R.raw.k182;
            case 183: return R.raw.k183;
            case 184: return R.raw.k184;
            case 185: return R.raw.k185;
            case 186: return R.raw.k186;
            case 187: return R.raw.k187;
            case 188: return R.raw.k188;
            case 189: return R.raw.k189;
            case 190: return R.raw.k190;
            case 191: return R.raw.k191;
            case 192: return R.raw.k192;
            case 193: return R.raw.k193;
            case 194: return R.raw.k194;
            case 195: return R.raw.k195;
            case 196: return R.raw.k196;
            case 197: return R.raw.k197;
            case 198: return R.raw.k198;
            case 199: return R.raw.k199;
            case 200: return R.raw.k200;
            case 201: return R.raw.k201;
            case 202: return R.raw.k202;
            case 203: return R.raw.k203;
            case 204: return R.raw.k204;
            case 205: return R.raw.k205;
            case 206: return R.raw.k206;
            case 207: return R.raw.k207;
            case 208: return R.raw.k208;
            case 209: return R.raw.k209;
            case 210: return R.raw.k210;
            case 211: return R.raw.k211;
            case 212: return R.raw.k212;
            case 213: return R.raw.k213;
            case 214: return R.raw.k214;
            default: return 0;
        }
    }
}
