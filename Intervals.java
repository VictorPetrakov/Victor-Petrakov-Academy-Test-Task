import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Intervals {

    public static String intervalConstruction(String[] args) throws Exception {

        Map<String, IntervalQuantity> list = new HashMap<>();

        if (validIntervalConstructor(args) == true) {

            String[] notes = {"C", "D", "E", "F", "G", "A", "B"};
            String[] listForFoundInterval = new String[3];

            list = initIntervalForConstructor();
            int findSemitone = list.get(args[0]).getSemitone();
            int findDegrees = list.get(args[0]).getDegrees();
            int startNotePosition = Arrays.asList(notes).indexOf(args[1].substring(0, 1));

            String outPutNote;

            if (args.length > 2) {
                if (args[2].equals("asc") || args[2].equals("") || args[2].equals(null)) {

                    int endNotePosition = startNotePosition + (findDegrees - 1);

                    if (endNotePosition > 6) {
                        endNotePosition = endNotePosition - 7;
                    }

                    outPutNote = notes[endNotePosition];

                    listForFoundInterval[0] = args[1];
                    listForFoundInterval[1] = notes[endNotePosition];
                    listForFoundInterval[2] = "asc";
                    int findSemitone1 = findQuantitySemitone(listForFoundInterval);


                    if (findSemitone != findSemitone1) {
                        if ((findSemitone - findSemitone1) > 0) {
                            if ((findSemitone - findSemitone1) == 1) {
                                outPutNote = outPutNote + "#";
                            } else {
                                outPutNote = outPutNote + "##";
                            }
                        } else {
                            if ((findSemitone - findSemitone1) == -1) {
                                outPutNote = outPutNote + "b";
                            } else {
                                outPutNote = outPutNote + "bb";
                            }
                        }

                    }
                    return outPutNote;
                } else {
                    int endNotePosition = startNotePosition - (findDegrees - 1);

                    if (endNotePosition < 0) {
                        endNotePosition = endNotePosition + 7;
                    }

                    outPutNote = notes[endNotePosition];

                    listForFoundInterval[0] = args[1];
                    listForFoundInterval[1] = notes[endNotePosition];
                    listForFoundInterval[2] = "dsc";
                    int findSemitone1 = findQuantitySemitone(listForFoundInterval);

                    if (findSemitone != findSemitone1) {
                        if ((findSemitone - findSemitone1) < 0) {
                            if ((findSemitone - findSemitone1) == -1) {
                                outPutNote = outPutNote + "#";
                            } else {
                                outPutNote = outPutNote + "##";
                            }
                        } else {
                            if ((findSemitone - findSemitone1) == 1) {
                                outPutNote = outPutNote + "b";
                            } else {
                                outPutNote = outPutNote + "bb";
                            }
                        }

                    }
                    return outPutNote;
                }
            } else {
                int endNotePosition = startNotePosition + (findDegrees - 1);

                if (endNotePosition > 6) {
                    endNotePosition = endNotePosition - 7;
                }

                outPutNote = notes[endNotePosition];

                listForFoundInterval[0] = args[1];
                listForFoundInterval[1] = notes[endNotePosition];
                listForFoundInterval[2] = "asc";
                int findSemitone1 = findQuantitySemitone(listForFoundInterval);

                if (findSemitone != findSemitone1) {
                    if ((findSemitone - findSemitone1) > 0) {
                        if ((findSemitone - findSemitone1) == 1) {
                            outPutNote = outPutNote + "#";
                        } else {
                            outPutNote = outPutNote + "##";
                        }
                    } else {
                        if ((findSemitone - findSemitone1) == -1) {
                            outPutNote = outPutNote + "b";
                        } else {
                            outPutNote = outPutNote + "bb";
                        }
                    }

                }
                return outPutNote;
            }
        } else {
            throw new Exception("Illegal number of elements in input array");
        }
    }

    public static String intervalIdentification(String[] args) throws Exception {

        String result;

        if (validIntervalIdentification(args) == true) {

            String[] notes = {"C", "D", "E", "F", "G", "A", "B"};

            int findSemitone;
            int findDegrees;

            int startNotePosition = Arrays.asList(notes).indexOf(args[0].substring(0, 1));
            int endNotePosition = Arrays.asList(notes).indexOf(args[1].substring(0, 1));

            if (args.length > 2) {
                if (args[2].equals("asc") || args[2].equals("") || args[2].equals(null)) {
                    if (startNotePosition < endNotePosition) {
                        findDegrees = (endNotePosition - startNotePosition) + 1;
                        if ((startNotePosition <= 2 && endNotePosition <= 2) || (startNotePosition >= 3 && endNotePosition >= 3)) {
                            findSemitone = (findDegrees - 1) * 2;
                        } else {
                            findSemitone = ((findDegrees - 1) * 2) - 1;
                        }
                    } else {
                        findDegrees = ((endNotePosition + 7) - startNotePosition) + 1;
                        if (startNotePosition <= 2 && endNotePosition <= 2 || startNotePosition > 2 && endNotePosition <= 2) {
                            findSemitone = ((findDegrees - 1) * 2) - 1;
                        } else {
                            findSemitone = ((findDegrees - 1) * 2) - 2;
                        }
                    }
                    if (args[0].length() > 1 && args[1].length() > 1) {
                        if (args[0].contains("b") || args[0].contains("bb")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                        if (args[0].contains("#") || args[0].contains("##")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                        if (args[1].contains("b") || args[1].contains("bb")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                        if (args[1].contains("#") || args[1].contains("##")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                    }
                    if (args[0].length() > 1 && args[1].length() == 1) {
                        if (args[0].contains("b") || args[0].contains("bb")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                        if (args[0].contains("#") || args[0].contains("##")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                    }
                    if (args[0].length() == 1 && args[1].length() > 1) {
                        if (args[1].contains("b") || args[1].contains("bb")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                        if (args[1].contains("#") || args[1].contains("##")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                    }
                    if (initIntervalForIdentification().get(findDegrees + findSemitone) == null) {
                        throw new Exception("Cannot identify the interval");
                    } else {
                        result = initIntervalForIdentification().get(findDegrees + findSemitone);
                    }

                    return result;
                } else {
                    if (startNotePosition > endNotePosition) {
                        findDegrees = (startNotePosition - endNotePosition) + 1;
                        if ((startNotePosition <= 2 && endNotePosition <= 2) || (startNotePosition >= 3 && endNotePosition >= 3)) {
                            findSemitone = (findDegrees - 1) * 2;
                        } else {
                            findSemitone = ((findDegrees - 1) * 2) - 1;
                        }
                    } else {
                        findDegrees = ((startNotePosition + 7) - endNotePosition) + 1;
                        if (startNotePosition <= 2 && endNotePosition <= 2 || startNotePosition > 2 && endNotePosition <= 2) {
                            findSemitone = ((findDegrees - 1) * 2) - 2;
                        } else {
                            findSemitone = ((findDegrees - 1) * 2) - 1;
                        }
                    }
                    if (args[0].length() > 1 && args[1].length() > 1) {
                        if (args[0].contains("b") || args[0].contains("bb")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                        if (args[0].contains("#") || args[0].contains("##")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                        if (args[1].contains("b") || args[1].contains("bb")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                        if (args[1].contains("#") || args[1].contains("##")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                    }
                    if (args[0].length() > 1 && args[1].length() == 1) {
                        if (args[0].contains("b") || args[0].contains("bb")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                        if (args[0].contains("#") || args[0].contains("##")) {
                            if (args[0].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                    }
                    if (args[0].length() == 1 && args[1].length() > 1) {
                        if (args[1].contains("b") || args[1].contains("bb")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone + 2;
                            } else {
                                findSemitone = findSemitone + 1;
                            }
                        }
                        if (args[1].contains("#") || args[1].contains("##")) {
                            if (args[1].length() > 2) {
                                findSemitone = findSemitone - 2;
                            } else {
                                findSemitone = findSemitone - 1;
                            }
                        }
                    }

                    if (initIntervalForIdentification().get(findDegrees + findSemitone) == null) {
                        throw new Exception("Cannot identify the interval");
                    } else {
                        result = initIntervalForIdentification().get(findDegrees + findSemitone);
                    }

                    return result;
                }
            } else {
                if (startNotePosition < endNotePosition) {
                    findDegrees = (endNotePosition - startNotePosition) + 1;
                    if ((startNotePosition <= 2 && endNotePosition <= 2) || (startNotePosition >= 3 && endNotePosition >= 3)) {
                        findSemitone = (findDegrees - 1) * 2;
                    } else {
                        findSemitone = ((findDegrees - 1) * 2) - 1;
                    }
                } else {
                    findDegrees = ((endNotePosition + 7) - startNotePosition) + 1;
                    if (startNotePosition <= 2 && endNotePosition <= 2 || startNotePosition > 2 && endNotePosition <= 2) {
                        findSemitone = ((findDegrees - 1) * 2) - 1;
                    } else {
                        findSemitone = ((findDegrees - 1) * 2) - 2;
                    }
                }
                if (args[0].length() > 1 && args[1].length() > 1) {
                    if (args[0].contains("b") || args[0].contains("bb")) {
                        if (args[0].length() > 2) {
                            findSemitone = findSemitone + 2;
                        } else {
                            findSemitone = findSemitone + 1;
                        }
                    }
                    if (args[0].contains("#") || args[0].contains("##")) {
                        if (args[0].length() > 2) {
                            findSemitone = findSemitone - 2;
                        } else {
                            findSemitone = findSemitone - 1;
                        }
                    }
                    if (args[1].contains("b") || args[1].contains("bb")) {
                        if (args[1].length() > 2) {
                            findSemitone = findSemitone - 2;
                        } else {
                            findSemitone = findSemitone - 1;
                        }
                    }
                    if (args[1].contains("#") || args[1].contains("##")) {
                        if (args[1].length() > 2) {
                            findSemitone = findSemitone + 2;
                        } else {
                            findSemitone = findSemitone + 1;
                        }
                    }
                }
                if (args[0].length() > 1 && args[1].length() == 1) {
                    if (args[0].contains("b") || args[0].contains("bb")) {
                        if (args[0].length() > 2) {
                            findSemitone = findSemitone + 2;
                        } else {
                            findSemitone = findSemitone + 1;
                        }
                    }
                    if (args[0].contains("#") || args[0].contains("##")) {
                        if (args[0].length() > 2) {
                            findSemitone = findSemitone - 2;
                        } else {
                            findSemitone = findSemitone - 1;
                        }
                    }
                }
                if (args[0].length() == 1 && args[1].length() > 1) {
                    if (args[1].contains("b") || args[1].contains("bb")) {
                        if (args[1].length() > 2) {
                            findSemitone = findSemitone - 2;
                        } else {
                            findSemitone = findSemitone - 1;
                        }
                    }
                    if (args[1].contains("#") || args[1].contains("##")) {
                        if (args[1].length() > 2) {
                            findSemitone = findSemitone + 2;
                        } else {
                            findSemitone = findSemitone + 1;
                        }
                    }
                }

                if (initIntervalForIdentification().get(findDegrees + findSemitone) == null) {
                    throw new Exception("Cannot identify the interval");
                } else {
                    result = initIntervalForIdentification().get(findDegrees + findSemitone);
                }

                return result;
            }
        } else {
            throw new Exception("Illegal number of elements in input array");
        }

    }

    public static int findQuantitySemitone(String[] args) {
        String[] notes = {"C", "D", "E", "F", "G", "A", "B"};

        int findSemitone;
        int findDegrees;

        int startNotePosition = Arrays.asList(notes).indexOf(args[0].substring(0, 1));
        int endNotePosition = Arrays.asList(notes).indexOf(args[1].substring(0, 1));

        if (args[2].equals("asc") || args[2].equals("") || args[2].equals(null)) {
            if (startNotePosition < endNotePosition) {
                findDegrees = (endNotePosition - startNotePosition) + 1;
                if ((startNotePosition <= 2 && endNotePosition <= 2) || (startNotePosition >= 3 && endNotePosition >= 3)) {
                    findSemitone = (findDegrees - 1) * 2;
                } else {
                    findSemitone = ((findDegrees - 1) * 2) - 1;
                }
            } else {
                findDegrees = ((endNotePosition + 7) - startNotePosition) + 1;
                if (startNotePosition <= 2 && endNotePosition <= 2 || startNotePosition > 2 && endNotePosition <= 2) {
                    findSemitone = ((findDegrees - 1) * 2) - 1;
                } else {
                    findSemitone = ((findDegrees - 1) * 2) - 2;
                }
            }
            if (args[0].length() > 1 && args[1].length() > 1) {
                if (args[0].contains("b")) {
                    findSemitone = findSemitone + 1;
                }
                if (args[0].contains("#")) {
                    findSemitone = findSemitone - 1;
                }
                if (args[1].contains("b")) {
                    findSemitone = findSemitone - 1;
                }
                if (args[1].contains("#")) {
                    findSemitone = findSemitone + 1;
                }
            }
            if (args[0].length() > 1 && args[1].length() == 1) {
                if (args[0].contains("b")) {
                    findSemitone = findSemitone + 1;
                }
                if (args[0].contains("#")) {
                    findSemitone = findSemitone - 1;
                }
            }
            if (args[0].length() == 1 && args[1].length() > 1) {
                if (args[1].contains("b") || args[1].contains("bb")) {
                    if (args[1].length() > 2) {
                        findSemitone = findSemitone - 2;
                    } else {
                        findSemitone = findSemitone - 1;
                    }
                }
                if (args[1].contains("#") || args[1].contains("##")) {
                    if (args[1].length() > 2) {
                        findSemitone = findSemitone + 2;
                    } else {
                        findSemitone = findSemitone + 1;
                    }
                }
            }
            return findSemitone;
        } else {
            if (startNotePosition > endNotePosition) {
                findDegrees = (startNotePosition - endNotePosition) + 1;
                if ((startNotePosition <= 2 && endNotePosition <= 2) || (startNotePosition >= 3 && endNotePosition >= 3)) {
                    findSemitone = (findDegrees - 1) * 2;
                } else {
                    findSemitone = ((findDegrees - 1) * 2) - 1;
                }
            } else {
                findDegrees = ((startNotePosition + 7) - endNotePosition) + 1;
                if (startNotePosition <= 2 && endNotePosition <= 2 || startNotePosition > 2 && endNotePosition <= 2) {
                    findSemitone = ((findDegrees - 1) * 2) - 2;
                } else {
                    findSemitone = ((findDegrees - 1) * 2) - 1;
                }
            }
            if (args[0].length() > 1 && args[1].length() > 1) {
                if (args[0].contains("b")) {
                    findSemitone = findSemitone - 1;
                }
                if (args[0].contains("#")) {
                    findSemitone = findSemitone + 1;
                }
                if (args[1].contains("b")) {
                    findSemitone = findSemitone + 1;
                }
                if (args[1].contains("#")) {
                    findSemitone = findSemitone - 1;
                }
            }
            if (args[0].length() > 1 && args[1].length() == 1) {
                if (args[0].contains("b")) {
                    findSemitone = findSemitone - 1;
                }
                if (args[0].contains("#")) {
                    findSemitone = findSemitone + 1;
                }
            }
            if (args[0].length() == 1 && args[1].length() > 1) {
                if (args[1].contains("b")) {
                    findSemitone = findSemitone + 1;
                }
                if (args[1].contains("#")) {
                    findSemitone = findSemitone - 1;
                }
            }

            return findSemitone;
        }
    }

    public static boolean validIntervalConstructor(String[] args) {
        String[] validIntervals = {"m2", "M2", "m3", "M3", "P4", "P5", "m6", "M6", "m7", "M7", "P8"};
        String[] validNotesForConstructor = {"Cb", "C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#"};

        if (args.length == 2 || args.length == 3) {
            if (args.length == 2) {
                if (Arrays.asList(validIntervals).contains(args[0]) && Arrays.asList(validNotesForConstructor).contains(args[1])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (Arrays.asList(validIntervals).contains(args[0]) && Arrays.asList(validNotesForConstructor).contains(args[1]) && (args[2].equals("asc") || args[2].equals("dsc") || args[2].equals("") || args[2] == null)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static boolean validIntervalIdentification(String[] args) {

        String[] validNotesForIdentification = {"Cbb", "Cb", "C", "C#", "C##", "Dbb", "Db", "D", "D#", "D##", "Ebb", "Eb", "E", "E#", "E##", "Fbb", "Fb", "F", "F#", "F##", "Gbb", "Gb", "G", "G#", "G##", "Abb", "Ab", "A", "A#", "A##", "Bbb", "Bb", "B", "B#", "B##"};
        if (args.length == 2 || args.length == 3) {
            if (args.length == 2) {
                if (Arrays.asList(validNotesForIdentification).contains(args[0]) && Arrays.asList(validNotesForIdentification).contains(args[1])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (Arrays.asList(validNotesForIdentification).contains(args[0]) && Arrays.asList(validNotesForIdentification).contains(args[1]) && (args[2].equals("asc") || args[2].equals("dsc") || args[2].equals("") || args[2] == null)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static Map<String, IntervalQuantity> initIntervalForConstructor() {

        Map<String, IntervalQuantity> intervalQuantityMap = new HashMap<>();
        intervalQuantityMap.put("m2", new IntervalQuantity(1, 2));
        intervalQuantityMap.put("M2", new IntervalQuantity(2, 2));
        intervalQuantityMap.put("m3", new IntervalQuantity(3, 3));
        intervalQuantityMap.put("M3", new IntervalQuantity(4, 3));
        intervalQuantityMap.put("P4", new IntervalQuantity(5, 4));
        intervalQuantityMap.put("P5", new IntervalQuantity(7, 5));
        intervalQuantityMap.put("m6", new IntervalQuantity(8, 6));
        intervalQuantityMap.put("M6", new IntervalQuantity(9, 6));
        intervalQuantityMap.put("m7", new IntervalQuantity(10, 7));
        intervalQuantityMap.put("M7", new IntervalQuantity(11, 7));
        intervalQuantityMap.put("P8", new IntervalQuantity(12, 8));

        return intervalQuantityMap;
    }

    public static Map<Integer, String> initIntervalForIdentification() {

        Map<Integer, String> intervalQuantityMap = new HashMap<>();
        intervalQuantityMap.put(3, "m2");
        intervalQuantityMap.put(4, "M2");
        intervalQuantityMap.put(6, "m3");
        intervalQuantityMap.put(7, "M3");
        intervalQuantityMap.put(9, "P4");
        intervalQuantityMap.put(12, "P5");
        intervalQuantityMap.put(14, "m6");
        intervalQuantityMap.put(15, "M6");
        intervalQuantityMap.put(17, "m7");
        intervalQuantityMap.put(18, "M7");
        intervalQuantityMap.put(20, "P8");

        return intervalQuantityMap;
    }

    public static class IntervalQuantity {

        private int semitone;
        private int degrees;

        public IntervalQuantity(int semitone, int degrees) {
            this.semitone = semitone;
            this.degrees = degrees;
        }

        public IntervalQuantity() {
        }


        public int getSemitone() {
            return semitone;
        }

        public void setSemitone(int semitone) {
            this.semitone = semitone;
        }

        public int getDegrees() {
            return degrees;
        }

        public void setDegrees(int degrees) {
            this.degrees = degrees;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + degrees;
            result = prime * result + semitone;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            IntervalQuantity other = (IntervalQuantity) obj;
            if (degrees != other.degrees)
                return false;
            if (semitone != other.semitone)
                return false;
            return true;
        }

    }

}

